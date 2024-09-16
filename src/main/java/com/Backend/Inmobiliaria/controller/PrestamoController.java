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
import com.Backend.Inmobiliaria.Repository.ClienteRepo;
import com.Backend.Inmobiliaria.Repository.PrestamoRepo;
import com.Backend.Inmobiliaria.Repository.ProductoRepo;
import com.Backend.Inmobiliaria.model.Cliente;
import com.Backend.Inmobiliaria.model.Compra;
import com.Backend.Inmobiliaria.model.Prestamo;
import com.Backend.Inmobiliaria.model.Producto;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/prestamos")
public class PrestamoController {

	@Autowired
	private PrestamoRepo presRepo;

	@Autowired
	private ClienteRepo cliRepo;
	
	@Autowired
	private ProductoRepo proRepo;

	@GetMapping("/listarPrestamos")
	public List<Prestamo> listarPrestamos() {
		return presRepo.findAll();
	}

	@GetMapping("/listarPrestamosActivos")
	public List<Prestamo> listarPrestamosActivos() {
		return presRepo.findByActivo(true);
	}

	@GetMapping("/listarPrestamosInactivos")
	public List<Prestamo> listarPrestamosInactivos() {
		return presRepo.findByActivo(false);
	}

	@Transactional
	@PostMapping("/crearPrestamo")
	public Prestamo crearPrestamo(@RequestBody Prestamo pres) {
		Cliente cli = cliRepo.findByPersona(pres.getCliente().getPersona());
		if (cli != null)
			pres.setCliente(cli);
		else {
			System.out.println(pres.getCliente());
			Cliente nuevoCli = cliRepo.save(pres.getCliente());
			System.out.println(nuevoCli);
			pres.setCliente(nuevoCli);
		}
		return presRepo.save(pres);
	}
	
	@GetMapping({"/getPrestamo/{id}"})
	public ResponseEntity<Prestamo> getPrestamo(@PathVariable int id) {
		Prestamo pres = presRepo.get_Prestamo(id);
		return ResponseEntity.ok(pres);
	}
	
	@GetMapping({"/buscarPrestamo/{idpro}"})
	public List<Prestamo> buscarPrestamo(@PathVariable int idpro){
		return presRepo.buscarPrestamoPorProducto(idpro);
	}

	@Transactional
	@PutMapping("/eliminarPrestamo")
	public ResponseEntity<Prestamo> eliminarPrestamo(@RequestBody Prestamo pres) {
		presRepo.eliminarPrestamo(pres.getId_pres());
		for (int i = 0; i < pres.getProductos().size(); i++) {
			Producto pro = pres.getProductos().get(i);
			pro.setActivo_pro(false);
			pro.setEn_prenda(false);
			proRepo.save(pro);
		}
		return ResponseEntity.ok(pres);
	}

	@PutMapping("/desempeñar")
	public ResponseEntity<Prestamo> desempeñarPrestamo(@RequestBody Prestamo pres) {
		Prestamo presMod = presRepo.save(pres);
		return ResponseEntity.ok(presMod);
	}

	@PutMapping("/modEstadoPrestamo")
	public ResponseEntity<Prestamo> modEstadoPrestamo(@RequestBody Prestamo pres) {
		pres.setActivo(!pres.isActivo());
		Prestamo presMod = presRepo.save(pres);
		return ResponseEntity.ok(presMod);
	}

	@Transactional
	@PutMapping("/modPlazoPrestamo")
	public ResponseEntity<Prestamo> modPlazoPrestamo(@RequestBody Prestamo pres) {
		presRepo.modificarDatos(pres.getId_pres(), pres.getMonto(), pres.getMonto_tot(), pres.getPlazo_pres());
		return ResponseEntity.ok(pres);
	}
	
	@Transactional
	@PutMapping("/modPlazoExtra")
	public ResponseEntity<Prestamo> plazoExtra(@RequestBody Prestamo pres) {
		presRepo.plazoExtra(pres.getId_pres(), pres.getFechaven());
		return ResponseEntity.ok(pres);
	}

	// RECARGAS // ***********************************************************************************

	@GetMapping("/listarRecargas")
	public List<Prestamo> listarRecargas() {
		return presRepo.listarRecargas();
	}
	
	@GetMapping("/getPrestamoPorRecarga/{id}")
	public Prestamo getPrestamoPorRecarga(@PathVariable int id) {
		return presRepo.findPrestamoByRecargaId(id);
	}
	
	@GetMapping("/getPrestamoPorAmpliacion/{id}")
	public Prestamo getPrestamoPorAmpliacion(@PathVariable int id) {
		return presRepo.findPrestamoByAmpliacionId(id);
	}
	
	@Transactional
	@PutMapping("/modificarFechasRecarga")
	public ResponseEntity<Prestamo> addRecarga(@RequestBody Prestamo pres) {
		presRepo.modificarFechasRecarga(pres.getId_pres(), pres.getFechaini(), pres.getFechafin());
		return ResponseEntity.ok(pres);
	}
}
