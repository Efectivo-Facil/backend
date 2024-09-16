package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.FotosProd;
import com.Backend.Inmobiliaria.model.Producto;

@Repository
public interface FotosProdRepo extends JpaRepository<FotosProd, Integer>{
	Boolean existsByProducto(Producto pro);
}
