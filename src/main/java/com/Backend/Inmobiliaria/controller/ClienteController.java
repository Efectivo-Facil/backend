package com.Backend.Inmobiliaria.controller;

import java.util.List;
import java.util.Optional;

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
import com.Backend.Inmobiliaria.Repository.PersonaRepo;
import com.Backend.Inmobiliaria.exception.ResourceNotFoundException;
import com.Backend.Inmobiliaria.model.Cliente;
import com.Backend.Inmobiliaria.model.Persona;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepo cliRepo;
	@Autowired
	private PersonaRepo perRepo;
	
	@GetMapping("/listaClientes")
	public List<Cliente> listarClientes(){
		return cliRepo.findAll();
	}
	
	@PostMapping("/crearCliente")
	public Cliente crearCliente (@RequestBody Cliente cli) throws ResourceNotFoundException {
		List<Persona> per = perRepo.findByCi(cli.getPersona().getCi());
		if (!per.isEmpty()) {
	        throw new ResourceNotFoundException("El ci ingresado ya se encuentra registrado.");
	    }
		
        Cliente nuevoCli = cliRepo.save(cli);
        return nuevoCli;
	}
	
	@PutMapping("/modCliente")
	public ResponseEntity<Cliente> modificarPersona(@RequestBody Cliente cli){
		Persona perMod = cli.getPersona();
		Persona perModificada = perRepo.save(perMod);
		
		cli.setPersona(perModificada);
		cliRepo.save(cli);
		return ResponseEntity.ok(cli);	
	}
	
	@PutMapping("/actualizarCliente")
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") int id, @RequestBody Cliente clienteModificado) {
		Optional<Cliente> clienteExistente = cliRepo.findById(id);
	    
	    if (clienteExistente.isPresent()) {
	        Cliente cliente = clienteExistente.get();
	        
	        // Modifica los datos del cliente con los valores proporcionados en el objeto clienteModificado
	        cliente.setDire_cli(clienteModificado.getDire_cli());
	        cliente.setCorreo_cli(clienteModificado.getCorreo_cli());
	        
	        // Modifica los datos de la persona asociada al cliente
	        Persona persona = cliente.getPersona();
	        persona.setCi(clienteModificado.getPersona().getCi());
	        persona.setCi_expedido(clienteModificado.getPersona().getCi_expedido());
	        persona.setNombres_per(clienteModificado.getPersona().getNombres_per());
	        persona.setPrimer_ap(clienteModificado.getPersona().getPrimer_ap());
	        persona.setSegundo_ap(clienteModificado.getPersona().getSegundo_ap());
	        persona.setCelular_per(clienteModificado.getPersona().getCelular_per());
	        
	        // Guarda los cambios en la base de datos
	        cliRepo.save(cliente);
	        
	        return ResponseEntity.ok(cliente);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
}
