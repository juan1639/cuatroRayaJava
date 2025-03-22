package com.ejemplo.juan1639;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejemplo.juan1639.tablero.Board;

@SpringBootApplication
public class Juan1639Application implements CommandLineRunner
{
	public static void main(String[] args)
	{
		SpringApplication.run(Juan1639Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		new Board();
	}
}
