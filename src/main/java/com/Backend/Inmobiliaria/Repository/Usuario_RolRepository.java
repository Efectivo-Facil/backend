package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Usuario_Rol;
import com.Backend.Inmobiliaria.model.Usuario_Rol_PK;

@Repository
public interface Usuario_RolRepository extends JpaRepository <Usuario_Rol, Usuario_Rol_PK>{

}
