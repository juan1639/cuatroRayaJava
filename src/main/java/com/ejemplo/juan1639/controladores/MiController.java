package com.ejemplo.juan1639.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiController
{
	@GetMapping("/index")
	public String holaMundo()
	{
		return "index";
	}
}
