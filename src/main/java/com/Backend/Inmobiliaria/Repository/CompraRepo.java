package com.Backend.Inmobiliaria.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Cliente;
import com.Backend.Inmobiliaria.model.Compra;
import com.Backend.Inmobiliaria.model.Encargado;
import com.Backend.Inmobiliaria.model.Persona;
import com.Backend.Inmobiliaria.model.Producto;

@Repository
public interface CompraRepo extends JpaRepository <Compra, Integer>{

	
	@Query(value = "select com.* from compra com, detalle_compra dc, producto pro "
			+ "where com.id_com = dc.id_com and dc.id_pro = pro.id_pro and pro.id_pro=?1", nativeQuery = true)
	public List<Compra> buscarCompraPorProducto(int idpro);
	
	@Query(value = "select * from compra where id_com=?1", nativeQuery = true)
	public Compra get_Compra(int id);
	
}
