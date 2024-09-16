package com.Backend.Inmobiliaria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Cliente;
import com.Backend.Inmobiliaria.model.Persona;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer>{
	
	Cliente findByPersona(Persona per);
	
}

