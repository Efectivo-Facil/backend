package com.Backend.Inmobiliaria.model;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.CascadeType;
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
@Table(name = "movimiento")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_mov")
	@GenericGenerator(name = "id_mov", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",  parameters = {
            @Parameter(name = "sequence_name", value = "id_mov"),
            @Parameter(name = "initial_value", value = "10"),
            @Parameter(name = "increment_size", value = "1")
    })
	private int id_mov;
	@Column(name = "tipo_mov")
	private String tipo_mov;
	@Column(name = "seccion_mov")
	private String seccion_mov;
	@Column(name = "desc_mov")
	private String desc_mov;
	@Column(name = "id_seccion")
	private int idseccion;
	@Column(name = "fecha")
	private Date fecha;
	@Column(name = "monto_mov")
	private int monto_mov;
	
	@ManyToOne()
	@JoinColumn(name = "id_usu")
	private Usuario usuario;

	
	public int getIdseccion() {
		return idseccion;
	}

	public void setIdseccion(int idseccion) {
		this.idseccion = idseccion;
	}

	public int getId_mov() {
		return id_mov;
	}

	public void setId_mov(int id_mov) {
		this.id_mov = id_mov;
	}

	public String getTipo_mov() {
		return tipo_mov;
	}

	public void setTipo_mov(String tipo_mov) {
		this.tipo_mov = tipo_mov;
	}

	public String getSeccion_mov() {
		return seccion_mov;
	}

	public void setSeccion_mov(String seccion_mov) {
		this.seccion_mov = seccion_mov;
	}

	public String getDesc_mov() {
		return desc_mov;
	}

	public void setDesc_mov(String desc_mov) {
		this.desc_mov = desc_mov;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getMonto_mov() {
		return monto_mov;
	}

	public void setMonto_mov(int monto_mov) {
		this.monto_mov = monto_mov;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
