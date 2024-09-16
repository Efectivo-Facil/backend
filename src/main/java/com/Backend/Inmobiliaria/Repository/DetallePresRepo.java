package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Backend.Inmobiliaria.model.DetallePrestamo;
import com.Backend.Inmobiliaria.model.DetallePrestamoPK;

@Repository
public interface DetallePresRepo extends JpaRepository <DetallePrestamo, DetallePrestamoPK> {

}
