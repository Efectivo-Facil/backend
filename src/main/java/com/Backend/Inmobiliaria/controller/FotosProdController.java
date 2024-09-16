package com.Backend.Inmobiliaria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Backend.Inmobiliaria.Repository.FotosProdRepo;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;

import com.Backend.Inmobiliaria.model.FotosProd;


@RestController
@RequestMapping("/api/v1")
public class FotosProdController {

	@Autowired
	private FotosProdRepo fpRepo;
	
	@GetMapping("/listaFotosProd")
	public List<FotosProd> listarFotosProd(){
		return fpRepo.findAll();
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<FotosProd> buscarPorId(@PathVariable int id){
		FotosProd enc = fpRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("La Foto del Producto no existe"));
		return ResponseEntity.ok(enc);	
	}
	
	@PostMapping("/crearFotosProd")
	public FotosProd crearFotosProd (@RequestBody FotosProd fp) {
		/*if (fpRepo.existsByProducto(fp.getProducto())) {
	        throw new IllegalArgumentException("El producto vinculado ala foto ya esta vinculada a otro");
	    }*/
	    return fpRepo.save(fp);
	}
	
	@PutMapping("/editarFotosProd/{id}")
	public ResponseEntity<FotosProd> actualizarFotosProd(@PathVariable int id, @RequestBody FotosProd fpRequest){
	FotosProd fotosprod = fpRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("La foto con ese ID no existe : "+id));
	
	fotosprod.setUrl_foto(fpRequest.getUrl_foto());
	//fotosprod.setProducto(fpRequest.getProducto());
	
	FotosProd FotosProdActualizado = fpRepo.save(fotosprod);
	return ResponseEntity.ok(FotosProdActualizado);
	}
    
	//preguntar si hacemos eliminar ////////////////////////// ver si lo borra de producto
	
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarFotoProd(@PathVariable Integer id){
	FotosProd fotosprod = fpRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("La foto con ese ID no existe : "+id));
	fpRepo.delete(fotosprod);
	Map<String,Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	
	///si da //////
	}
}
