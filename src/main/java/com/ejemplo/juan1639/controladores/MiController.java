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
	
    public MiController(Board tablero) {
        this.tablero = tablero;
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
		//Integer[][] arrayInt = tablero.getArrayInt();
		tablero.ActualizarBoardConNuevaFicha(columna);
		
		if (!tablero.getTurno()) { // Si después de la jugada es turno de la IA
	        return "redirect:/jugadaIA";
	    }
		//tablero.setArrayInt(arrayInt);
		
		return "redirect:/index";
	}
	
	@GetMapping("/jugadaIA")
	public String jugarIA(Model model) {
	    tablero.ActualizarBoardConNuevaFicha(-999); // Simula la jugada de la IA
	    return "redirect:/index";
	}
}
