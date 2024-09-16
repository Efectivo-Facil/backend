package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository; 
import com.Backend.Inmobiliaria.model.Venta;


@Repository
public interface VentaRepo extends JpaRepository <Venta, Integer>{

	@Query(value = "select * from venta where id_ven=?1", nativeQuery = true)
	public Venta get_Venta(int id);
}
