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

import com.Backend.Inmobiliaria.Repository.EncargadoRepo;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Encargado;
import com.Backend.Inmobiliaria.model.Persona;
import com.Backend.Inmobiliaria.model.Usuario;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/encargados")
public class EncargadoController {

	@Autowired
	private EncargadoRepo encRepo;
	
	@GetMapping("/listaEncargados")
	public List<Encargado> listarEncargados(){
		return encRepo.findAll();
	}
	
	@GetMapping("/listaEncargadosSinUsuarios")
	public List<Encargado> listaEncargadosSinUsuarios(){
		return encRepo.listaEncargadosSinUsuario();
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Encargado> buscarPorCi(@PathVariable int id){
		Encargado enc = encRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El encargado no existe"));
		return ResponseEntity.ok(enc);	
	}
	
	@PostMapping("/crearEncargado")
	public Encargado crearEncargado (@RequestBody Encargado enc) {
		
	    return encRepo.save(enc);
	}
	
}
