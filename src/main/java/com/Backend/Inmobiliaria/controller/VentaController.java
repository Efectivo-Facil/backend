package com.Backend.Inmobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Inmobiliaria.Repository.ClienteRepo;
import com.Backend.Inmobiliaria.Repository.VentaRepo;
import com.Backend.Inmobiliaria.model.Cliente;
import com.Backend.Inmobiliaria.model.Compra;
import com.Backend.Inmobiliaria.model.Venta;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ventas")
public class VentaController {

	@Autowired
	public VentaRepo vRepo;
	
	@Autowired
	private ClienteRepo cliRepo;
	
	@GetMapping({"/listaVenta"})
	public List<Venta> listaVenta(){
		return vRepo.findAll();
	}
	
	@Transactional
	@PostMapping("/crearVenta")
	public Venta crearVenta (@RequestBody Venta ven) {
		Cliente cli = cliRepo.findByPersona(ven.getCliente().getPersona());
		if (cli != null) 
			ven.setCliente(cli);
	    else {
	    	System.out.println(ven.getCliente());
	    	Cliente nuevoCli = cliRepo.save(ven.getCliente());
	    	ven.setCliente(nuevoCli);
	    }
	    return vRepo.save(ven);
	}
	
	@GetMapping({"/getVenta/{id}"})
	public Venta getVenta(@PathVariable int id){
		return vRepo.get_Venta(id);
	}
	
}
