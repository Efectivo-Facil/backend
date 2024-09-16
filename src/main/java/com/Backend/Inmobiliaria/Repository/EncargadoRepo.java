package com.Backend.Inmobiliaria.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Encargado;
import com.Backend.Inmobiliaria.model.Persona;
import com.Backend.Inmobiliaria.model.Prestamo;

@Repository
public interface EncargadoRepo extends JpaRepository<Encargado, Integer> {

	Boolean existsByPersona(Persona per);
	
	@Modifying
	@Query(value = "insert into usuario (nom_usu, pass_usu, activo_usu, id_enc) values (:nom_usu, :pass_usu, true, :id_enc)", nativeQuery = true)
	public int asignarUsuario (@Param("nom_usu") String nom, @Param("pass_usu") String pass, @Param("id_enc") int id);

	@Query(value = "SELECT e.* FROM encargado e WHERE e.id_enc NOT IN (SELECT id_enc FROM usuario)", nativeQuery = true)
	public List<Encargado> listaEncargadosSinUsuario();
	
}
