package com.Backend.Inmobiliaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "desempeño")
public class Desempeño {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_des")
	@GenericGenerator(name = "id_des", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",  parameters = {
            @Parameter(name = "sequence_name", value = "id_des"),
            @Parameter(name = "initial_value", value = "10"),
            @Parameter(name = "increment_size", value = "1")
    })
	private int id_des;
	@Column(name = "fecha_des")
	private Date fecha_des;
	@Column(name = "duracion")
	private int duracion;
	@Column(name = "monto_fin")
	private float monto_fin;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="id_pres")
	private Prestamo prestamo;

	public int getId_des() {
		return id_des;
	}

	public void setId_des(int id_des) {
		this.id_des = id_des;
	}

	public Date getFecha_des() {
		return fecha_des;
	}

	public void setFecha_des(Date fecha_des) {
		this.fecha_des = fecha_des;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public float getMonto_fin() {
		return monto_fin;
	}

	public void setMonto_fin(float monto_fin) {
		this.monto_fin = monto_fin;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
}
