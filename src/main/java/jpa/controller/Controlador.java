package jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Tcliente> obtenerClientes() {
		
		return servicio.obtenerClientes();
	}
	
	@GetMapping("/obtenerPedidos")
	public List<Tpedido> obtenerPedidos(){
		return servicio.obtenerPedidos();
	}
	
	@PostMapping("/insertarPedido")
	@CrossOrigin(origins = "http://localhost:4200")
	public void insertarPedido(@RequestBody Tpedido pedido){
		servicio.insertarPedido(pedido);
	}
	
	@PostMapping("/insertarCliente")
	@CrossOrigin(origins = "http://localhost:4200")
	public void insertarCliente(@RequestBody Tcliente cliente){
		servicio.insertarCliente(cliente);
	}
	
	@PostMapping("/actualizarCliente")
	@CrossOrigin(origins = "http://localhost:4200")
	public void actualizarCliente(@RequestBody Tcliente cliente){
		servicio.actualizarCliente(cliente);
	}
	
	@PostMapping("/logging")
	@CrossOrigin(origins = "http://localhost:4200")
	public Tusuario logging(@RequestBody Tusuario usuario) {
		return servicio.logging(usuario);
	}
}
