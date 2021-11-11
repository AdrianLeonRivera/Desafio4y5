package com.example.desafio3spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.desafio3spring.entities.Cliente;
import com.example.desafio3spring.services.ClienteServiceI;

@Controller
@RequestMapping(value = "/clientes")
public class ClienteController {
	
	@Autowired
	ClienteServiceI clienteService;
	
	@GetMapping(value = "/listaclientes")
	public String listadoClientes(Model modelo)
	{
		modelo.addAttribute("clientes", clienteService.mostrarCliente());
		return "listaclientes";
	}
	
	@GetMapping(value = "/insertarcliente")
	public String insertarCliente()
	{
		return "insertarcliente"; 
	}
	
	@PostMapping(value = "/insertarcliente")
	public String guardarCliente(@ModelAttribute("cliente")Cliente cli)
	{
		clienteService.añadirCliente(cli);
		return "redirect:/clientes/listaclientes";
	}
	
	@GetMapping(value = "/buscarcliente")
	public String buscarCliente()
	{
		return "buscarcliente";
	}
	
	@PostMapping(value = "/buscarcliente")
	public String buscarClienteLista(@RequestParam("nombre") String nombre, @RequestParam("apellidos") String apellidos, Model modelo)
	{
		modelo.addAttribute("cliente", clienteService.findByNombreAndApellidos(nombre, apellidos));
		return "redirect:/clientes/listaclientes";
	}
	
	@RequestMapping(value="/borrarcliente")
	public String borrarClienteLista(Long id)
	{
		clienteService.borrarClienteId(id);
		return "redirect:/clientes/listaclientes";
	}
}
