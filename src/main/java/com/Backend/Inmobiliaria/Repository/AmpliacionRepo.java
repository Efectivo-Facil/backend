package com.Backend.Inmobiliaria.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Backend.Inmobiliaria.model.Ampliacion;
import com.Backend.Inmobiliaria.model.Compra;

@Repository
public interface AmpliacionRepo extends JpaRepository <Ampliacion, Integer>{

	@Modifying
	@Query(value = "insert into ampliacion (plazo_ant, plazo_nuevo, monto_ant, monto_nuevo, fecha, id_pres) values "
			+ "(:plazo, :plazon, :monto, :monton, :fecha, :id)", nativeQuery = true)
	public int add_Ampliacion(int plazo, int plazon, int monton, int monto, Date fecha, int id);
	
	@Query(value = "select * from ampliacion where id_am=?1", nativeQuery = true)
	public Ampliacion get_Ampliacion(int id);
	
}
