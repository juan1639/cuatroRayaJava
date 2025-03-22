package com.ejemplo.juan1639.logica;

import com.ejemplo.juan1639.entidades.CasillaSwing;
import com.ejemplo.juan1639.tablero.Board;

public class RealizarJugada
{
	private Integer valor;
	private Integer indice;
	private Integer fila;
	private Integer columna;
	
	private Board tablero;
	
	public RealizarJugada(Integer valor, Integer indice, Integer fila, Integer columna, Board tablero)
	{
		super();
		this.valor = valor;
		this.indice = indice;
		this.fila = fila;
		this.columna = columna;
		this.tablero = tablero;
		
		this.tablero.ActualizarBoardConNuevaFicha(this.columna);
	}
	
	public RealizarJugada(Board tablero)
	{
		this.tablero = tablero;
	}
	
	public void MostrarBoardValoresEnConsola()
	{
		Integer contador = 0;
		
		for (CasillaSwing casilla : tablero.getArrayCasillas())
		{
			contador ++;
			
			if (contador.equals(7))
			{
				System.out.println(casilla.getValor() + " ");
				contador = 0;
			}
			else
			{
				System.out.print(casilla.getValor() + " ");
			}
		}
	}
}
