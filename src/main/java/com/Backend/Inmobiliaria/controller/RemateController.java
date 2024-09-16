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

import com.Backend.Inmobiliaria.Repository.ProductoRepo;
import com.Backend.Inmobiliaria.Repository.RemateRepo;
import com.Backend.Inmobiliaria.model.Desempeño;
import com.Backend.Inmobiliaria.model.Producto;
import com.Backend.Inmobiliaria.model.Remate;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/remates")
public class RemateController {

	@Autowired
	private RemateRepo remRepo;
	@Autowired
	private ProductoRepo proRepo;
	
	@GetMapping("/listarRemates")
	public List<Remate> listarDesempeños(){
		return remRepo.findAll();
	}
	
	@Transactional
	@PostMapping("/crearRemate/{xid}")
	public int crearRemate (@PathVariable int xid, @RequestBody Remate rem) {
		if (remRepo.add_Remate(rem.getDuracion(), rem.getFecha(), xid, rem.getPrestamo().getPeriodo_pres()) > 0) {
			for(int i=0; i<rem.getPrestamo().getProductos().size(); i++) {
				Producto pro = rem.getPrestamo().getProductos().get(i);
				pro.setEn_prenda(false);
				proRepo.save(pro);
			}
		}
	    return 0;
	}
	
	@GetMapping("/getRemate/{id}")
	public Remate getRemate(@PathVariable int id){
		return remRepo.get_Remate(id);
	}
}
