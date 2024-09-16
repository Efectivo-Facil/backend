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
import com.Backend.Inmobiliaria.Repository.RecargaRepo;
import com.Backend.Inmobiliaria.model.Recarga;
import jakarta.transaction.Transactional; 
import java.util.Date; 

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/recargas")
public class RecargaController {
	
	@Autowired
	private RecargaRepo recRepo;
	
	@GetMapping("/listarRecargas")
	public List<Recarga> listarDesempeños(){
		return recRepo.findAll();
	}
	
	@GetMapping("/getRecarga/{id}")
	public Recarga getRecarga(@PathVariable int id){
		return recRepo.get_Recarga_Id(id);
	}
	
	@Transactional
	@PostMapping("/crearRecarga/{xid}")
	public int crearRecarga (@PathVariable int xid, @RequestBody Recarga rec) {
		if (rec.getNro_recarga() > 1) {
			Recarga anterior = recRepo.get_Recarga(xid, rec.getNro_recarga()-1);
			
			Date fechaInicio = anterior.getFecha_ini_ant(); 
			Date fechaActual = rec.getFecha_ini_ant(); 
			long diferenciaEnMilisegundos = Math.abs(fechaActual.getTime() - fechaInicio.getTime());
			long diasTranscurridos = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24);
			
			recRepo.add_Recarga(0, rec.getFecha(), rec.getMonto_int(), rec.getNro_recarga(), 
		    		rec.getFecha_ini_ant(), rec.getFecha_fin_ant(), xid);
			
			recRepo.mod_Recarga_Anterior((int)diasTranscurridos, rec.getFecha_ini_ant(), rec.getNro_recarga()-1, xid);
			
		}else {
			recRepo.add_Recarga(0, rec.getFecha(), rec.getMonto_int(), rec.getNro_recarga(), 
		    		rec.getFecha_ini_ant(), rec.getFecha_fin_ant(), xid);
		}
	    return 1;
	}
}
