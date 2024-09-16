package com.Backend.Inmobiliaria.Repository;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.Backend.Inmobiliaria.model.Desempeño;
import com.Backend.Inmobiliaria.model.Remate;

public interface RemateRepo extends JpaRepository <Remate, Integer>{

	@Modifying
	@Query(value = "insert into remate (duracion, fecha, id_pres) values "
			+ "(:duracion, :fecha1, :id);"
			+ "update prestamo set activo_pres=false, periodo_pres=:per where id_pres=:id ;", nativeQuery = true)
	public int add_Remate (int duracion, Date fecha1, int id, int per);
	
	@Query(value = "select * from remate where id_pres=?1", nativeQuery = true)
	Remate get_Remate(int id);
	
}
