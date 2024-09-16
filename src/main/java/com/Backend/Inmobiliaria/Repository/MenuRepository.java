package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Menu;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}
