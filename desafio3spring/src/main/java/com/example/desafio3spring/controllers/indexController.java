package com.example.desafio3spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController 
{
	@GetMapping(value = "/index")
	public String showIndex()
	{
		return "index";
	}
	
}
