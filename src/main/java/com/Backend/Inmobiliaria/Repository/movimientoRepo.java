package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Backend.Inmobiliaria.model.Movimiento;

@Repository
public interface movimientoRepo extends JpaRepository<Movimiento, Integer>{

	@Query(value = "select * from movimiento where id_seccion=?1 and seccion_mov='EMPEÑO'", nativeQuery = true)
	Movimiento get_Mov_Creacion_Prestamo(int id);
}
