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
import com.Backend.Inmobiliaria.Repository.movimientoRepo;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Movimiento; 

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/movimientos")
public class movimientoController {

	@Autowired
	private movimientoRepo movRepo;
	
	@GetMapping("/listaMovimientos")
	public List<Movimiento> listarMovimientos(){
		return movRepo.findAll();
	}
	
	@GetMapping("/buscar/{ci}")
	public ResponseEntity<Movimiento> buscarPorId(@PathVariable int id){
		Movimiento mov = movRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("El Movimiento no existe"));
		System.out.println(mov);
		return ResponseEntity.ok(mov);	
	}
		
	@PostMapping("/crearMovimiento")
	public Movimiento crearMovimiento (@RequestBody Movimiento mov) {
	    return movRepo.save(mov);
	}
	
	@PutMapping("/modMovimientos")
	public ResponseEntity<Movimiento> modificarMovimientos(@RequestBody Movimiento mov){
		Movimiento movMod = movRepo.findById(mov.getId_mov())
				.orElseThrow(() -> new ResourceNotFoundException("El movimiento no existe"));
		Movimiento movModificada = movRepo.save(movMod);
		
		return ResponseEntity.ok(movModificada);	
		
	}

	@GetMapping("/getCreacionPrestamo/{id}")
	public Movimiento getCreacionPrestamo(@PathVariable int id){
		return movRepo.get_Mov_Creacion_Prestamo(id);
	}

}
