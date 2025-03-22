package com.ejemplo.juan1639.logica;

import com.ejemplo.juan1639.main.Settings;
import com.ejemplo.juan1639.tablero.Board;

public class RealizarJugadaIA
{
	private static Integer[][] copiaArrayInt;
	private static Boolean banderaCheckPrimeraVacia = false;

	private Board tablero;
	private Checks checks;

	public RealizarJugadaIA(Board tablero, Checks checks)
	{
		this.tablero = tablero;
		this.checks = checks;
	}

	public RealizarJugadaIA(Board tablero)
	{
		this.tablero = tablero;
	}

	public RealizarJugadaIA()
	{
	}

	public Integer[] checkSiIA4Raya(Integer ID_JUGADOR)
	{
		for (int columna = 0; columna < Settings.COLUMNAS; columna++)
		{
			banderaCheckPrimeraVacia = false;
			Integer FILAS = Settings.FILAS - 1;

			for (Integer i = FILAS; i >= 0; i--)
			{
				if (this.tablero.getArrayInt()[i][columna] == Settings.INIT_TO_ZERO && !banderaCheckPrimeraVacia)
				{
					copiaArrayInt = this.tablero.getArrayInt();
					copiaArrayInt[i][columna] = ID_JUGADOR;
					this.tablero.setArrayInt(copiaArrayInt);

					if (this.checks.checkDiagonales(ID_JUGADOR) || this.checks.checkHorVer(ID_JUGADOR, 0, 1)
							|| this.checks.checkHorVer(ID_JUGADOR, 1, 0))
					{
						copiaArrayInt[i][columna] = Settings.INIT_TO_ZERO;
						this.tablero.setArrayInt(copiaArrayInt);

						return new Integer[]
						{ i, columna };
					}

					copiaArrayInt[i][columna] = Settings.INIT_TO_ZERO;
					this.tablero.setArrayInt(copiaArrayInt);

					banderaCheckPrimeraVacia = true;
				}
			}
		}

		return new Integer[]
		{ -9, -9 };
	}

	public static int jugadaRandom()
	{
		return (int) Math.floor(Math.random() * Settings.COLUMNAS);
	}
}
