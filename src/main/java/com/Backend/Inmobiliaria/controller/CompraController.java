package com.Backend.Inmobiliaria.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Inmobiliaria.Repository.ClienteRepo;
import com.Backend.Inmobiliaria.Repository.CompraRepo;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Cliente;
import com.Backend.Inmobiliaria.model.Compra;
import com.Backend.Inmobiliaria.model.Persona;
import com.Backend.Inmobiliaria.model.Prestamo;
import com.Backend.Inmobiliaria.model.Producto;


import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/compras")
public class CompraController {

	@Autowired
	public CompraRepo cRepo;
	
	@Autowired
	private ClienteRepo cliRepo;
	
	@GetMapping({"/listaCompras"})
	public List<Compra> listaCompra(){
		return cRepo.findAll();
	}
	
	@GetMapping({"/buscarCompra/{idpro}"})
	public List<Compra> buscarCompra(@PathVariable int idpro){
		return cRepo.buscarCompraPorProducto(idpro);
	}
	
	@GetMapping({"/getCompra/{id}"})
	public Compra getCompra(@PathVariable int id){
		return cRepo.get_Compra(id);
	}
	
	@Transactional
	@PostMapping("/crearCompra")
	public Compra crearCompra (@RequestBody Compra com) {
		Cliente cli = cliRepo.findByPersona(com.getCliente().getPersona());
		if (cli != null) 
			com.setCliente(cli);
	    else {
	    	System.out.println(com.getCliente());
	    	Cliente nuevoCli = cliRepo.save(com.getCliente());
	    	com.setCliente(nuevoCli);
	    }
	    return cRepo.save(com);
	}
	  // Endpoint para obtener los nombres de los productos asociados con una compra específica
    @GetMapping("/{idCompra}/productos")
    public List<String> getNombresProductosDeCompra(@PathVariable int idCompra) {
        // Obtener la compra por su ID
        Optional<Compra> optionalCompra = cRepo.findById(idCompra);

        // Verificar si la compra existe
        if (optionalCompra.isPresent()) {
            Compra compra = optionalCompra.get();
            List<String> nombresProductos = new ArrayList<>();
            // Obtener los nombres de los productos asociados con la compra
            for (Producto producto : compra.getProductos()) {
                nombresProductos.add(producto.getNombre_pro());
            }
            return nombresProductos;
        } else {
            // Si la compra no existe, devolver una lista vacía
            return new ArrayList<>();
        }
    }
}
