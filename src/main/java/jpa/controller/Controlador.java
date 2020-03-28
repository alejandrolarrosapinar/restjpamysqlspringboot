package jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jpa.domain.Tcliente;
import jpa.domain.Tpedido;
import jpa.domain.Tusuario;
import jpa.service.Service;

@RestController
public class Controlador {

	private Service servicio;
	
	public Controlador() {
		this.servicio=new Service();
		System.out.println("inicializando controlador");
	}
	
	@GetMapping("/obtenerUsuarios")
	public List<Tusuario> obtenerUsuarios() {
		return servicio.obtenerUsuarios();
	}
	
	@GetMapping("/obtenerClientes")
	public List<Tcliente> obtenerClientes() {
		
		return servicio.obtenerClientes();
	}
	
	@GetMapping("/obtenerPedidos")
	public List<Tpedido> obtenerPedidos(){
		return servicio.obtenerPedidos();
	}
	
	@PostMapping("/insertarPedido")
	public void insertarPedido(@RequestBody Tpedido pedido){
		servicio.insertarPedido(pedido);
	}
	
	@PostMapping("/insertarCliente")
	public void insertarCliente(@RequestBody Tcliente cliente){
		servicio.insertarCliente(cliente);
	}
}
