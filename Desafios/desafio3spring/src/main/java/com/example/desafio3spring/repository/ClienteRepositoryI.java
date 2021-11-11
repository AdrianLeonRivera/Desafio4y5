package com.example.desafio3spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.desafio3spring.entities.Cliente;

public interface ClienteRepositoryI extends JpaRepository<Cliente, Long>{
	Cliente findByNombreAndApellidos(String nombre, String apellidos);
}
