package com.Backend.Inmobiliaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Backend.Inmobiliaria.Repository.PersonaRepo;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Persona;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaRepo perRepo;
	
	@GetMapping("/listaPersonas")
	public List<Persona> listarPersonas(){
		return perRepo.findAll();
	}
	
	@GetMapping("/buscar/{ci}")
	public ResponseEntity<Persona> buscarPorCi(@PathVariable long id){
		Persona per = perRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("La persona no existe"));
		System.out.println(per);
		return ResponseEntity.ok(per);	
	}
	
	@PostMapping("/crearPersona")
	public Persona crearPersona (@RequestBody Persona per) {
		if (perRepo.existsById((long) per.getId_per())) {
	        throw new IllegalArgumentException("El número de identificación ya existe en la base de datos");
	    }
	    return perRepo.save(per);
	}
	
	@PutMapping("/modPersona")
	public ResponseEntity<Persona> modificarPersona(@RequestBody Persona per){
		Persona perMod = perRepo.findById((long) per.getId_per())
				.orElseThrow(() -> new ResourceNotFoundException("La persona no existe"));
		
		perMod.setCi(per.getCi());
		perMod.setNombres_per(per.getNombres_per());
		perMod.setCi_expedido(per.getCi_expedido());
		perMod.setPrimer_ap(per.getPrimer_ap());
		perMod.setSegundo_ap(per.getSegundo_ap());
		perMod.setCelular_per(per.getCelular_per());
		
		Persona perModificada = perRepo.save(perMod);
		return ResponseEntity.ok(perModificada);	
	}
	
}
