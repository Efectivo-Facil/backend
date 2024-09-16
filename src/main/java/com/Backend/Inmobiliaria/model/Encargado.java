package com.Backend.Inmobiliaria.model;

import java.util.Date;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

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

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "encargado")
public class Encargado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_enc")
	@GenericGenerator(name = "id_enc", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",  parameters = {
            @Parameter(name = "sequence_name", value = "id_enc"),
            @Parameter(name = "initial_value", value = "10"),
            @Parameter(name = "increment_size", value = "1")
    })
	private int id_enc;
	@Column(name = "fecha_ing")
	private Date fecha_ing;
	
	@OneToOne
	@Cascade(CascadeType.ALL) 
	@JoinColumn(name="id_per")
	private Persona persona;
	
	@OneToOne(mappedBy="encargado")
	private Usuario usuario; 

	public int getId_enc() {
		return id_enc;
	}

	public Date getFecha_ing() {
		return fecha_ing;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
}
