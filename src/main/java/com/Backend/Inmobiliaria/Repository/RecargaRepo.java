package com.Backend.Inmobiliaria.Repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Prestamo;
import com.Backend.Inmobiliaria.model.Recarga;

@Repository
public interface RecargaRepo extends JpaRepository <Recarga, Integer>{

	@Modifying
	@Query(value = "insert into recarga (duracion, fecha, monto_int, nro_recarga, fecha_ini_ant, fecha_fin_ant, id_pres) values "
			+ "(:duracion, :fecha1, :monto, :num, :fecha2, :fecha3, :id)", nativeQuery = true)
	public int add_Recarga (int duracion, Date fecha1, int monto, int num, Date fecha2, Date fecha3, int id);
	
	
	@Modifying
	@Query(value = "update recarga set fecha_fin_ant=:fecha1, duracion=:duracion where id_pres=:id and nro_recarga=:num", nativeQuery = true)
	public int mod_Recarga_Anterior (int duracion, Date fecha1, int num, int id);
	
	@Query(value = "select * from recarga where id_pres=:id and nro_recarga=:nro", nativeQuery = true)
	public Recarga get_Recarga(int id, int nro);
	
	@Query(value = "select * from recarga where id_re=:id", nativeQuery = true)
	public Recarga get_Recarga_Id(int id);
}
