package com.Backend.Inmobiliaria.Repository;

import java.util.Date;
import org.springframework.data.jpa.repository.Query; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.Backend.Inmobiliaria.model.Compra;
import com.Backend.Inmobiliaria.model.Prestamo;

@Repository
public interface PrestamoRepo extends JpaRepository <Prestamo, Integer> {

	List<Prestamo> findByFechainiBetween(Date startDate, Date endDate);
	
	List<Prestamo> findByActivo(boolean estado);
	
	@Query(value = "SELECT DISTINCT p.* FROM prestamo p "
			+ "JOIN recarga r ON p.id_pres = r.id_pres", nativeQuery = true)
	public List<Prestamo> listarRecargas();
	
	@Query(value = "select pres.* from prestamo pres, detalle_prestamo dp, producto pro "
			+ "where pres.id_pres = dp.id_pres and dp.id_pro = pro.id_pro and pro.id_pro=?1", nativeQuery = true)
	public List<Prestamo> buscarPrestamoPorProducto(int idpro);
	
	@Query(value = "select * from prestamo where id_pres=:id", nativeQuery = true)
	public Prestamo get_Prestamo(int id);
	
	@Modifying
	@Query(value = "update prestamo set plazo_pres=?4, monto=?2, monto_tot=?3 where id_pres=?1", nativeQuery = true)
	public int modificarDatos(int id, double monto, double montotot, int plazo);
	
	@Modifying
	@Query(value = "update prestamo set fecha_ven=?2 where id_pres=?1", nativeQuery = true)
	public int plazoExtra(int id, Date fecha);
	
	@Modifying
	@Query(value = "update prestamo set fecha_ini=?2, fecha_fin=?3, fecha_ven=?3, periodo_pres=0 where id_pres=?1", nativeQuery = true)
	public int modificarFechasRecarga(int id, Date fecha1, Date fecha2);
	
	@Modifying
	@Query(value = "update prestamo set activo_pres=false where id_pres=?1", nativeQuery = true)
	public int eliminarPrestamo(int id);
	
	@Query("SELECT p FROM Prestamo p JOIN p.recargas r WHERE r.id =:recargaId")
    public Prestamo findPrestamoByRecargaId(int recargaId);
	
	@Query("SELECT p FROM Prestamo p JOIN p.ampliaciones r WHERE r.id =:ampId")
    public Prestamo findPrestamoByAmpliacionId(int ampId);
}
