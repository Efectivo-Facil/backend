package com.Backend.Inmobiliaria.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.Backend.Inmobiliaria.model.Desempeño; 

@Repository
public interface DesempeñoRepo extends JpaRepository <Desempeño, Integer> {

	@Query(value = "select * from desempeño where id_pres=?1", nativeQuery = true)
	Desempeño get_Desempeño(int id);
}
