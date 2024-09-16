package com.Backend.Inmobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Backend.Inmobiliaria.Repository.DetallePresRepo;
import com.Backend.Inmobiliaria.Repository.ProductoRepo;
import com.Backend.Inmobiliaria.model.Cliente;
import com.Backend.Inmobiliaria.model.DetallePrestamo;
import com.Backend.Inmobiliaria.model.Producto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/detallepres")
public class DetallePresController {

	@Autowired
	private DetallePresRepo detRepo;
	@Autowired
	private ProductoRepo proRepo;

	@PostMapping("/crearDetalle")
	public List<DetallePrestamo> crearDetalle(@RequestBody List<DetallePrestamo> pres) {
		for (int i = 0; i < pres.size(); i++) {
			Producto pro = proRepo.save(pres.get(i).getProducto());
			pres.get(i).setProducto(pro);
			detRepo.save(pres.get(i));
		}
		return pres;
	}
	
	@GetMapping("/listaDetallesPre")
	public List<DetallePrestamo> listarClientes(){
		return detRepo.findAll();
	}
}
