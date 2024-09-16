package com.Backend.Inmobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Inmobiliaria.Repository.DetalleComRepo;
import com.Backend.Inmobiliaria.Repository.ProductoRepo;
import com.Backend.Inmobiliaria.model.DetallePrestamo;
import com.Backend.Inmobiliaria.model.Detalle_Compra;
import com.Backend.Inmobiliaria.model.Producto;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/detallecom")
public class DetalleComController {

	
	@Autowired
	private DetalleComRepo detRepo;
	@Autowired
	private ProductoRepo proRepo;
	
	@PostMapping("/crearDetalle")
	public List<Detalle_Compra> crearDetalle(@RequestBody List<Detalle_Compra> pres) {
		for (int i = 0; i < pres.size(); i++) {
			Producto pro = proRepo.save(pres.get(i).getProducto());
			pres.get(i).setProducto(pro);
			detRepo.save(pres.get(i));
		}
		return pres;
	}
	
	@GetMapping("/listaDetallesCom")
	public List<Detalle_Compra> listarDetalleCompra(){
		return detRepo.findAll();
	}
}
