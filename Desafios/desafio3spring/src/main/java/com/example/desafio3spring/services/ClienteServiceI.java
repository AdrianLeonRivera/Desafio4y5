package com.example.desafio3spring.services;

import java.util.List;

import com.example.desafio3spring.entities.Cliente;


public interface ClienteServiceI {
	
	
	public void añadirCliente(Cliente cli);
	public List mostrarCliente();
	Cliente findByNombreAndApellidos(String nombre, String apellidos);
	public void borrarCliente(Cliente cli);

}
