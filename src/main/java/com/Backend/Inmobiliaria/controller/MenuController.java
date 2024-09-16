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
import com.Backend.Inmobiliaria.Repository.MenuRepository;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Menu;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class MenuController {
	
	@Autowired
	private MenuRepository menuRepository;

	@GetMapping("/menus")
	public List<Menu> listarMenu(){
		return menuRepository.findAll();
	}
	
	@PostMapping("/menus")
	public Menu guardarmenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}
	
	@GetMapping("/menus/{id}")
	public ResponseEntity<Menu> listarMenuPorId(@PathVariable Long id){
	Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Menu con ese ID no existe : "+id));
	return ResponseEntity.ok(menu);
	}
	
	@PutMapping("/menus/{id}")
	public ResponseEntity<Menu> actualizarMenu(@PathVariable Long id, @RequestBody Menu menuRequest){
	Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Menu con ese ID no existe : "+id));

	menu.setNombre_me(menuRequest.getNombre_me());
	menu.setUrl_me(menuRequest.getUrl_me());
	menu.setActivo_me(menuRequest.getActivo_me());
	
	Menu menuActualizado = menuRepository.save(menu);
	return ResponseEntity.ok(menuActualizado);
	}
	
	@DeleteMapping("/menus/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarMenu(@PathVariable Long id){
	Menu menu = menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El Menu con ese ID no existe : "+id));
	menuRepository.delete(menu);
	Map<String,Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	
	}
	
	
}
