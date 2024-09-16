package com.Backend.Inmobiliaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "recarga")
public class Recarga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_re")
	private int id_re;
	@Column(name = "nro_recarga")
	private int nro_recarga;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "fecha_ini_ant")
	private Date fecha_ini_ant;
	@Column(name = "fecha_fin_ant")
	private Date fecha_fin_ant;
	@Column(name = "duracion")
	private int duracion;
	@Column(name = "monto_int")
	private int monto_int;
	
	@ManyToOne
	@JoinColumn(name = "id_pres")
	private Prestamo prestamo;

	public int getId_re() {
		return id_re;
	}

	public void setId_re(int id_re) {
		this.id_re = id_re;
	}

	public int getNro_recarga() {
		return nro_recarga;
	}

	public void setNro_recarga(int nro_recarga) {
		this.nro_recarga = nro_recarga;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public int getMonto_int() {
		return monto_int;
	}

	public void setMonto_int(int monto_int) {
		this.monto_int = monto_int;
	}
	

	public Date getFecha_ini_ant() {
		return fecha_ini_ant;
	}

	public void setFecha_ini_ant(Date fecha_ini_ant) {
		this.fecha_ini_ant = fecha_ini_ant;
	}

	public Date getFecha_fin_ant() {
		return fecha_fin_ant;
	}

	public void setFecha_fin_ant(Date fecha_fin_ant) {
		this.fecha_fin_ant = fecha_fin_ant;
	}

}
