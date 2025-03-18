package com.ejemplo.juan1639.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiRestController
{
	@GetMapping("/")
	public String[] holaMundo()
	{
		return new String[] {"Hola", "Bienvenidos al centro IMI de Zalla"};
	}
}
