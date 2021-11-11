package com.example.desafio3spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.desafio3spring.entities.Cliente;
import com.example.desafio3spring.services.ClienteServiceI;

@SpringBootApplication
public class Desafio3springApplication implements CommandLineRunner{

	@Autowired
	ClienteServiceI clienteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Desafio3springApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
		Cliente cliente1=new Cliente();
		cliente1.setNombre("Juan");
		cliente1.setApellidos("Ramirez Gomez");
		cliente1.setDni("123456789");
		cliente1.setFecha_nac("1960-06-10");
		
		Cliente cliente2=new Cliente();
		cliente2.setNombre("Maria");
		cliente2.setApellidos("Ramirez Gomez");
		cliente2.setDni("123456789");
		cliente2.setFecha_nac("1960-08-10");
		
		clienteService.añadirCliente(cliente1);
		clienteService.añadirCliente(cliente2);
		
		List<Cliente>listaClientes=clienteService.mostrarCliente();
		
		System.out.println("Listado de clientes");
		System.out.println("-------------------");
		for (int i = 0; i < listaClientes.size(); i++) 
		{
			System.out.println(listaClientes.get(i).getNombre()+" "+listaClientes.get(i).getApellidos());
		}
		
		cliente1.setNombre("Ramon");
		clienteService.añadirCliente(cliente1);
		
		listaClientes=clienteService.mostrarCliente();
		System.out.println("-------------------");
		for (int i = 0; i < listaClientes.size(); i++) 
		{
			System.out.println(listaClientes.get(i).getNombre()+" "+listaClientes.get(i).getApellidos());
		}
		
		Cliente c=clienteService.findByNombreAndApellidos(cliente1.getNombre(), cliente1.getApellidos());;
		System.out.println(c.getNombre()+" "+c.getApellidos());
		//clienteService.borrarCliente(cliente1);
		
		
	}

}
