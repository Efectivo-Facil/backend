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
import com.Backend.Inmobiliaria.Repository.DesempeñoRepo;
import com.Backend.Inmobiliaria.model.Desempeño;
import com.Backend.Inmobiliaria.model.Prestamo;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/desempeños")
public class DesempeñoController {

	@Autowired
	private DesempeñoRepo desRepo;
	
	@GetMapping("/listarDesempeños")
	public List<Desempeño> listarDesempeños(){
		return desRepo.findAll();
	}
	
	@Transactional
	@PostMapping("/crearDesempeño")
	public Desempeño crearDesempeño (@RequestBody Desempeño des) {
	    return desRepo.save(des);
	}
	
	@GetMapping("/getDesempeño/{id}")
	public Desempeño getDesempeño(@PathVariable int id){
		return desRepo.get_Desempeño(id);
	}
	
}
