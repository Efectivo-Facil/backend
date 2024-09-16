package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.DetalleCompraPK;
import com.Backend.Inmobiliaria.model.Detalle_Compra;

@Repository
public interface DetalleComRepo extends JpaRepository <Detalle_Compra, DetalleCompraPK>{

}
