package com.Backend.Inmobiliaria.model;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ampliacion")
public class Ampliacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_am")
	private int id_am;
	@Column(name = "plazo_ant")
	private int plazo_ant;
	@Column(name = "plazo_nuevo")
	private int plazo_nuevo;
	@Column(name = "monto_ant")
	private int monto_ant;
	@Column(name = "monto_nuevo")
	private int monto_nuevo;
	@Column(name = "fecha")
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "id_pres", referencedColumnName = "id_pres")
	private Prestamo prestamo;

	
	public int getPlazo_nuevo() {
		return plazo_nuevo;
	}

	public void setPlazo_nuevo(int plazo_nuevo) {
		this.plazo_nuevo = plazo_nuevo;
	}

	public int getMonto_nuevo() {
		return monto_nuevo;
	}

	public void setMonto_nuevo(int monto_nuevo) {
		this.monto_nuevo = monto_nuevo;
	}

	public int getId_am() {
		return id_am;
	}

	public void setId_am(int id_am) {
		this.id_am = id_am;
	}

	public int getPlazo_ant() {
		return plazo_ant;
	}

	public void setPlazo_ant(int plazo_ant) {
		this.plazo_ant = plazo_ant;
	}

	public int getMonto_ant() {
		return monto_ant;
	}

	public void setMonto_ant(int monto_ant) {
		this.monto_ant = monto_ant;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
