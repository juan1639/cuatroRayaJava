package com.ejemplo.juan1639.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejemplo.juan1639.tablero.Board;

@Controller
public class MiController
{
	private final Board tablero;
	//private final IAServicio iaServicio;
	
	public MiController(Board tablero)
	{
		this.tablero = tablero;
		//this.iaServicio = iaServicio;
	}

	@GetMapping("/index")
	public String holaMundo(Model model)
	{
		Integer[][] arrayInt = tablero.getArrayInt();
		model.addAttribute("arrayInt", arrayInt);
		model.addAttribute("turno", tablero.getTurno()); // Enviamos el turno al frontend
		return "index";
	}

	@GetMapping("/tirarficha")
	public String tirarFicha(@RequestParam int columna, Model model)
	{
		tablero.ActualizarBoardConNuevaFicha(columna);
		
		/*
		 * if (!tablero.getTurno()) { iaServicio.jugarIAAsync(); }
		 */
		
		if (!tablero.getTurno())
		{
			return "redirect:/jugadaIA";
		}
		
		return "redirect:/index";
	}

	@GetMapping("/jugadaIA")
	public String jugarIA(Model model)
	{
		tablero.ActualizarBoardConNuevaFicha(-999); // Simula la jugada de la IA
		return "redirect:/index";
	}
}
