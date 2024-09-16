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
import com.Backend.Inmobiliaria.Repository.DetalleVenRepo;
import com.Backend.Inmobiliaria.Repository.ProductoRepo;
import com.Backend.Inmobiliaria.model.Detalle_Compra;
import com.Backend.Inmobiliaria.model.Detalle_Venta;
import com.Backend.Inmobiliaria.model.Producto;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/detalleven")
public class DetalleVenController {

	@Autowired
	private DetalleVenRepo detRepo;
	@Autowired
	private ProductoRepo proRepo;
	
	@PostMapping("/crearDetalle")
	public List<Detalle_Venta> crearDetalle(@RequestBody List<Detalle_Venta> pres) {
		for (int i = 0; i < pres.size(); i++) {
			Producto pro1 = pres.get(i).getProducto();
			pro1.setActivo_pro(false);
			Producto pro = proRepo.save(pro1);
			pres.get(i).setProducto(pro);
			detRepo.save(pres.get(i));
		}
		return pres;
	}
	
	@GetMapping("/listaDetallesVen")
	public List<Detalle_Venta> listarDetalleVenta(){
		return detRepo.findAll();
	}
}
