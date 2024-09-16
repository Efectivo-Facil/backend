package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{

}
