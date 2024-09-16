package com.Backend.Inmobiliaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backend.Inmobiliaria.Repository.Rol_MenuRepository;
import com.Backend.Inmobiliaria.model.Rol_Menu;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class Rol_MenuController {

	@Autowired
	public Rol_MenuRepository rmRepo;
	
	@GetMapping({"/listaRolMenu"})
	public List<Rol_Menu> listaRolmenu(){
		return rmRepo.findAll();
	}
	
}
