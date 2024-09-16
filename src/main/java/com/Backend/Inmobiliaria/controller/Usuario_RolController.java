package com.Backend.Inmobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Inmobiliaria.Repository.Usuario_RolRepository;
import com.Backend.Inmobiliaria.model.Rol_Menu;
import com.Backend.Inmobiliaria.model.Usuario_Rol;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class Usuario_RolController {

	@Autowired
	public Usuario_RolRepository urRepo;
	
	@GetMapping({"/listaUsuarioRol"})
	public List<Usuario_Rol> listaUsuarioRol(){
		return urRepo.findAll();
	}
}
