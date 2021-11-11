package com.example.desafio3spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio3spring.entities.Cliente;
import com.example.desafio3spring.repository.ClienteRepositoryI;

@Service
public class ClienteService implements ClienteServiceI{

	@Autowired
	public ClienteRepositoryI repository;
	
	@Override
	public Cliente findByNombreAndApellidos(String nombre, String apellidos) {
		return repository.findByNombreAndApellidos(nombre, apellidos);
	}

	@Override
	public void añadirCliente(Cliente cli) {
		repository.save(cli);
	}

	@Override
	public List mostrarCliente() {
		return repository.findAll();
	}

	@Override
	public void borrarCliente(Cliente cli) {
		repository.delete(cli);
		
	}

	@Override
	public void borrarClienteId(Long id) {
		repository.deleteById(id);
		
	}
}
