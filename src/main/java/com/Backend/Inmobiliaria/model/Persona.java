package com.Backend.Inmobiliaria.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "persona")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_per")
	@GenericGenerator(name = "id_per", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",  parameters = {
            @Parameter(name = "sequence_name", value = "id_per"),
            @Parameter(name = "initial_value", value = "10"),
            @Parameter(name = "increment_size", value = "1")
    })
	private int id_per;
	@Column(name = "ci_per")
	private String ci;
	@Column(name = "ci_expedido")
	private String ci_expedido;
	@Column(name = "nombres_per")
	private String nombres_per;
	@Column(name = "primer_ap")
	private String primer_ap;
	@Column(name = "segundo_ap")
	private String segundo_ap;
	@Column(name = "celular_per")
	private int celular_per;
	
	@OneToOne(mappedBy="persona")
	private Encargado encargado;
	
	@OneToOne(mappedBy="persona")
	private Cliente cliente;
	
	public int getId_per() {
		return id_per;
	}
	public void setId_per(int id_per) {
		this.id_per = id_per;
	}

	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getCi_expedido() {
		return ci_expedido;
	}
	public void setCi_expedido(String ci_expedido) {
		this.ci_expedido = ci_expedido;
	}
	public String getNombres_per() {
		return nombres_per;
	}
	public void setNombres_per(String nombres_per) {
		this.nombres_per = nombres_per;
	}
	public String getPrimer_ap() {
		return primer_ap;
	}
	public void setPrimer_ap(String primer_ap) {
		this.primer_ap = primer_ap;
	}
	public String getSegundo_ap() {
		return segundo_ap;
	}
	public void setSegundo_ap(String segundo_ap) {
		this.segundo_ap = segundo_ap;
	}
	public int getCelular_per() {
		return celular_per;
	}
	public void setCelular_per(int celular_per) {
		this.celular_per = celular_per;
	}
	@Override
	public String toString() {
		return "Persona [id_per=" + id_per + ", ci=" + ci + ", ci_expedido=" + ci_expedido + ", nombres_per="
				+ nombres_per + ", primer_ap=" + primer_ap + ", segundo_ap=" + segundo_ap + ", celular_per="
				+ celular_per + "]";
	}

	
}
