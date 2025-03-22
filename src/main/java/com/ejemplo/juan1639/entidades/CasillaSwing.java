package com.ejemplo.juan1639.entidades;

public class CasillaSwing
{
	private Integer valor;
	private Integer indice;
	private Integer fila;
	private Integer columna;
	
	public CasillaSwing(Integer valor, Integer indice, Integer fila, Integer columna)
	{
		this.valor = valor;
		this.indice = indice;
		this.fila = fila;
		this.columna = columna;
	}
	
	// ***********************************************************************
	// Getters & Setters
	//
	// ***********************************************************************
	public Integer getValor()
	{
		return valor;
	}

	public void setValor(Integer valor)
	{
		this.valor = valor;
	}

	public int getIndice()
	{
		return indice;
	}

	public void setIndice(int indice)
	{
		this.indice = indice;
	}

	public int getFila()
	{
		return fila;
	}

	public void setFila(int fila)
	{
		this.fila = fila;
	}

	public int getColumna()
	{
		return columna;
	}

	public void setColumna(int columna)
	{
		this.columna = columna;
	}
}
