package com.ejemplo.juan1639.tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import org.springframework.stereotype.Component;

import com.ejemplo.juan1639.entidades.CasillaSwing;
import com.ejemplo.juan1639.logica.Checks;
import com.ejemplo.juan1639.logica.RealizarJugada;
import com.ejemplo.juan1639.logica.RealizarJugadaIA;
import com.ejemplo.juan1639.main.Settings;

@Component
public class Board
{
	private static final long serialVersionUID = -7876218819488481472L;

	private final Integer ANCHO_JFRAME = Settings.TILE_X * Settings.COLUMNAS;
	private final Integer ALTO_JFRAME = Settings.TILE_Y * Settings.FILAS;

	private final Integer NUMERO_CASILLAS = Settings.NUMERO_CASILLAS;

	private CasillaSwing[] arrayCasillas = new CasillaSwing[NUMERO_CASILLAS];
	private Integer[][] arrayInt = new Integer[Settings.FILAS][Settings.COLUMNAS];
	
	private RealizarJugada realizarJugada;
	private RealizarJugadaIA realizarJugadaIA;
	private Checks checks;
	
	private Boolean turno = false;// TRUE=turnoJugador1 | FALSE=turnoIA/Jugador2
	private Integer contadorTiradasIA = 1;
	
	public Board()
	{
		turno = false;
		String idComenzar = turno ? "Jugador" : "AI";
		System.out.println("Comienza: " + idComenzar);
		
		checks = new Checks(this);
		realizarJugadaIA = new RealizarJugadaIA(this, checks);
		realizarJugada = new RealizarJugada(this);
		
		iniciar();
	}
	
	public void iniciar()
	{
		// Reseteamos SIEMPRE (rejugar y de paso siempre)
		Settings.setPreJuego(false);
		Settings.setEnJuego(true);
		contadorTiradasIA = 1;

		for (int i = 0; i < NUMERO_CASILLAS; i++)
		{
			arrayCasillas[i] = null;
		}

		// Tambien Vaciamos el panel y lo repintamos siempre
		// panel.removeAll();
		// panel.repaint();

		// Dibujar el Tablero de Juego / Draw GameBoard
		int i = 0;

		for (int fila = 0; fila < Settings.FILAS; fila++)
		{
			for (int col = 0; col < Settings.COLUMNAS; col++)
			{
				arrayInt[fila][col] = Settings.INIT_TO_ZERO;

				CasillaSwing casilla = new CasillaSwing(Settings.INIT_TO_ZERO, i, fila, col);
				arrayCasillas[i] = casilla;
				// JButton casillaBoton = casilla.getCasillaBoton();
				// panel.add(casillaBoton);
				i++;
			}
		}

		if (!turno)
		{
			callBackJugadaIA();
		}
	}
	
	public void ActualizarBoardConNuevaFicha(Integer columna)
	{
		System.out.println("columna: " + columna);

		if (!turno)
		{
			Integer[] checkIAWins = realizarJugadaIA.checkSiIA4Raya(Settings.IA_O_JUGADOR2);
			Integer[] checkIADefender = realizarJugadaIA.checkSiIA4Raya(Settings.JUGADOR);
			
			if (contadorTiradasIA < 2)
			{
				columna = 3;// Primera tirada coger el centro...

			} else if (checkIAWins[1] >= 0 && checkIAWins[1] < Settings.COLUMNAS)
			{
				columna = checkIAWins[1];

			} else if (checkIADefender[1] >= 0 && checkIADefender[1] < Settings.COLUMNAS)
			{
				columna = checkIADefender[1];

			} else
			{
				columna = RealizarJugadaIA.jugadaRandom();
			}
		}

		Integer idJugador = turno ? 1 : 2;

		Integer[] posicion2D = checks.checkBuscarPrimeraCasillaVacia(columna);

		if (posicion2D[1] <= -1 || posicion2D[1] >= Settings.COLUMNAS)
		{
			System.out.println("columna LLENA...");

			if (!turno)
			{
				ActualizarBoardConNuevaFicha(-999);
			}
			return;
		}

		Integer indice = Checks.getIndicePosicion(posicion2D);

		// ***********************************************************
		// Cambiar valor (Primitivos)
		//
		// ***********************************************************
		arrayCasillas[indice].setValor(idJugador);
		arrayInt[posicion2D[0]][posicion2D[1]] = idJugador;

		// ***********************************************************
		// Cambiar Componentes-Swing
		//
		// ***********************************************************
		// ImageIcon icono = new ImageIcon(turno ? Settings.Fichas.ROJA :
		// Settings.Fichas.AMARILLA);
		// Image imagen = icono.getImage().getScaledInstance(100, 100,
		// Image.SCALE_SMOOTH);
		// arrayCasillas[indice].getCasillaBoton().setIcon(new ImageIcon(imagen));

		// arrayCasillas[indice].getCasillaBoton().setHorizontalTextPosition(SwingConstants.CENTER);
		// arrayCasillas[indice].getCasillaBoton().setVerticalTextPosition(SwingConstants.CENTER);

		// panel.repaint(); // Re-renderizar el Board
		realizarJugada.MostrarBoardValoresEnConsola();

		if (checks.checkEmpate())
		{
			System.out.println("*** EMPATE ***");
			Settings.setEnJuego(false);
			Settings.setPuzzleResuelto(true);
			// OptionPanePrePost.prePostJuegoDialog(" EMPATE ");
			return;
		}

		if (checks.checkHorVer(idJugador, 0, 1) || checks.checkHorVer(idJugador, 1, 0)
				|| checks.checkDiagonales(idJugador))
		{
			System.out.println("*** CUATRO EN RAYA *** " + idJugador);
			Settings.setEnJuego(false);
			Settings.setPuzzleResuelto(true);

			String msgResultado = turno ? " ENHORABUENA! Jugador GANA! " : " IA GANA la partida ";
			// OptionPanePrePost.prePostJuegoDialog(msgResultado);
			return;
		}
		
		turno = !turno;

		if (!turno)
		{
			contadorTiradasIA++;
			//callBackJugadaIA();
		}
	}
	
	private void callBackJugadaIA()
	{
		Timer tiempoRespuestaIA = new Timer(2000, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				ActualizarBoardConNuevaFicha(-999);
			}
		});

		tiempoRespuestaIA.setRepeats(false);
		tiempoRespuestaIA.start();
	}

	// ***********************************************************************
	// Getters & Setters
	//
	// ***********************************************************************
	public CasillaSwing[] getArrayCasillas()
	{
		return arrayCasillas;
	}

	public void setArrayCasillas(CasillaSwing[] array_casillas)
	{
		arrayCasillas = array_casillas;
	}

	public Integer[][] getArrayInt()
	{
		return arrayInt;
	}

	public void setArrayInt(Integer[][] array_int)
	{
		arrayInt = array_int;
	}

	public Boolean getTurno()
	{
		return turno;
	}
}
