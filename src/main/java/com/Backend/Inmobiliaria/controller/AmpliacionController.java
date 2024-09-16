package com.Backend.Inmobiliaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Backend.Inmobiliaria.Repository.AmpliacionRepo;
import com.Backend.Inmobiliaria.model.Ampliacion;
import com.Backend.Inmobiliaria.model.Compra;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ampliaciones")
public class AmpliacionController {
	
	@Autowired
	private AmpliacionRepo amRepo;

	@Transactional
	@PostMapping("/crearAmpliacion/{xid}")
	public int crearAmpliacion (@PathVariable int xid, @RequestBody Ampliacion amp) {
	    return amRepo.add_Ampliacion(amp.getPlazo_ant(), amp.getPlazo_nuevo(), amp.getMonto_ant(), amp.getMonto_nuevo(), amp.getFecha(), xid);
	}
	
	@GetMapping({"/getAmpliacion/{id}"})
	public Ampliacion getAmpliacion(@PathVariable int id){
		return amRepo.get_Ampliacion(id);
	}
	
	
}
