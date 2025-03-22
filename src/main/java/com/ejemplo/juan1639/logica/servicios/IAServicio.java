package com.ejemplo.juan1639.logica.servicios;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ejemplo.juan1639.tablero.Board;

@Service
public class IAServicio
{
	private final Board tablero;

	public IAServicio(Board tablero)
	{
		this.tablero = tablero;
	}

	@Async
	public void jugarIAAsync()
	{
		try
		{
			Thread.sleep(2000); // Simula que la IA está pensando
		} catch (InterruptedException e)
		{
			Thread.currentThread().interrupt();
		}

		tablero.ActualizarBoardConNuevaFicha(-999); // Simula la jugada de la IA
	}
}
