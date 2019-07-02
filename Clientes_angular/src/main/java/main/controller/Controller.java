package main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import main.model.Clientes;
import main.model.repository.IClientesDAO;

@RestController
public class Controller {

	@Autowired
	IClientesDAO rp_cliente;
	
	@GetMapping("/clientes")
	public List<Clientes> getCelulares(){
		return this.rp_cliente.findAll();
	}
	
	@GetMapping("/clientes/{rut}")
	public Clientes getClientesRut(@PathVariable String rut) {
		if (this.rp_cliente.existsById(rut)) {
			return this.rp_cliente.findById(rut).get();
		}
		return null;
	}
	
	@GetMapping("/clientes/{nombre}")
	public Clientes getClientesNombres(@PathVariable String nombre) {
		if (this.rp_cliente.existsByNombres(nombre)) {
			return this.rp_cliente.findByNombres(nombre);
		}
		return null;
	}
	
	@PostMapping("/clientes")
	public boolean addClientes(@RequestBody Clientes nuevo) {

		if (!this.rp_cliente.existsById(nuevo.getRut())) {
			this.rp_cliente.save(nuevo);
			return true;
		}	
		return false;
	}
	
	@PutMapping("/clientes")
	public boolean updateClientes(@RequestBody Clientes mod) {

		if (this.rp_cliente.existsById(mod.getRut())) {
			this.rp_cliente.save(mod);
			return true;
		}	
		return false;
	}
	
	@DeleteMapping("/clientes/{rut}")
	public boolean deleteClientes(@PathVariable String rut) {
		
		if (rut.equals("99999999-9") && !rp_cliente.findAll().isEmpty()) {
			this.rp_cliente.deleteAll();
			return true;
		}else if (this.rp_cliente.existsById(rut)) {
			this.rp_cliente.deleteById(rut);
			return true;
		}
		return false;
	}
}
