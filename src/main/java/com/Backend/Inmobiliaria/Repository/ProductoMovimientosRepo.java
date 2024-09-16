package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.ProductoMovimientos;

@Repository
public interface ProductoMovimientosRepo extends JpaRepository<ProductoMovimientos, Integer> {
}