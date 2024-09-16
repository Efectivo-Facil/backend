package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Rol_Menu;
import com.Backend.Inmobiliaria.model.Rol_Menu_PK;

@Repository
public interface Rol_MenuRepository extends JpaRepository <Rol_Menu, Rol_Menu_PK>{

}
