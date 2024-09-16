package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Backend.Inmobiliaria.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

	@Query(value = "select * from usuario where nom_usu=?1 and pass_usu=?2", nativeQuery = true)
	Usuario verificaCuenta(String login, String passwd);
}
