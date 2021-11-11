package com.example.desafio3spring.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio3spring.entities.Cliente;
import com.example.desafio3spring.services.ClienteService;

@RestController
@RequestMapping(value="/rest")
public class ClienteRestController 
{
	@Autowired
	ClienteService clienteService;
	
	@GetMapping(value = "/todos")
	public @ResponseBody List<Cliente> mostrarClientes()
	{
		List<Cliente>listarClientes = clienteService.mostrarCliente();
		return listarClientes;
	}
	
	@PostMapping(value = "/insertar")
	public void insertarCliente(@RequestBody Cliente cliente)
	{
		clienteService.añadirCliente(cliente);
	}
	
	@PostMapping(value = "/borrar")
	public void borrarCliente(@RequestBody Cliente cliente)
	{
		clienteService.borrarCliente(cliente);
	}
	
	@PostMapping(value="/buscarnombre")
	public Cliente buscarPorNombre(@RequestBody String nombre, @RequestBody String apellidos)
	{
		Cliente c=clienteService.findByNombreAndApellidos(nombre, apellidos);
		return c;
	}
}
