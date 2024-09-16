package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.DetalleVentaPK;
import com.Backend.Inmobiliaria.model.Detalle_Venta;


@Repository
public interface DetalleVenRepo extends JpaRepository <Detalle_Venta, DetalleVentaPK>{

}
