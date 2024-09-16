package com.Backend.Inmobiliaria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Inmobiliaria.Repository.RolRepository;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Rol;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/roles")
public class RolController {
	
	@Autowired
	private RolRepository rolRepository;
	
	@GetMapping("/listaRoles")
	public List<Rol> listarRol(){
		return rolRepository.findAll();
	}
	
	@PostMapping("/crearRol")
	public Rol guardarRol(@RequestBody Rol rol) {
		return rolRepository.save(rol);
	}
	
	@GetMapping("/menusRol/{id}")
	public ResponseEntity<Rol> listarRolPorId(@PathVariable Integer id){
	Rol rol = rolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Rol con ese ID no existe : "+id));
	return ResponseEntity.ok(rol);
	}

	@PutMapping("/roles/{id}")
	public ResponseEntity<Rol> actualizarRol(@PathVariable Integer id, @RequestBody Rol rolRequest){
	Rol rol = rolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Rol con ese ID no existe : "+id));

	rol.setNombre_rol(rolRequest.getNombre_rol());
	rol.setActivo_rol(rolRequest.getActivo_rol());
	
	Rol rolActualizado = rolRepository.save(rol);
	return ResponseEntity.ok(rolActualizado);
	}
	
	@DeleteMapping("/roles/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarRol(@PathVariable Integer id){
	Rol rol = rolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Rol con ese ID no existe : "+id));
	rolRepository.delete(rol);
	Map<String,Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	
	}
}

