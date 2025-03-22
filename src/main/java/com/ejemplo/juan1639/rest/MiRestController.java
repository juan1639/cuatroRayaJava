package com.ejemplo.juan1639.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplo.juan1639.tablero.Board;

@RestController
public class MiRestController
{
	private final Board tablero;
	
    public MiRestController(Board tablero) {
        this.tablero = tablero;
    }
    
	@GetMapping("/")
	public String[] holaMundo()
	{
		return new String[] {"Hola", "Bienvenidos al centro IMI de Zalla"};
	}
	
	@GetMapping("/getArray")
	public Integer[][] getArray()
	{
		return tablero.getArrayInt();
	}
}
