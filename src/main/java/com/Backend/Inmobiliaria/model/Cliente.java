package com.Backend.Inmobiliaria.model;

import java.util.Date;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import java.util.List;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_cli")
	@GenericGenerator(name = "id_cli", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",  parameters = {
            @Parameter(name = "sequence_name", value = "id_cli"),
            @Parameter(name = "initial_value", value = "10"),
            @Parameter(name = "increment_size", value = "1")
    })
	private int id_cli;
	@Column(name = "dire_cli")
	private String dire_cli;
	@Column(name = "correo_cli")
	private String correo_cli;
	@Column(name = "fecha_reg")
	private Date fecha_reg;
	
	@OneToOne
	@Cascade(CascadeType.ALL) // Configuración de cascada
	@JoinColumn(name="id_per")
	private Persona persona;

	@OneToMany(mappedBy="cliente")
	private List<FotosCli> fotoscli;
	
	@OneToMany(mappedBy="cliente")
	private List<Prestamo> prestamos;
	
	public int getId_cli() {
		return id_cli;
	}

	public String getDire_cli() {
		return dire_cli;
	}

	public void setDire_cli(String dire_cli) {
		this.dire_cli = dire_cli;
	}

	public String getCorreo_cli() {
		return correo_cli;
	}

	public void setCorreo_cli(String correo_cli) {
		this.correo_cli = correo_cli;
	}

	public Date getFecha_reg() {
		return fecha_reg;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<FotosCli> getFotoscli() {
		return fotoscli;
	}

	public void setFotoscli(List<FotosCli> fotoscli) {
		this.fotoscli = fotoscli;
	}

	@Override
	public String toString() {
		return "Cliente [id_cli=" + id_cli + ", dire_cli=" + dire_cli + ", correo_cli=" + correo_cli + ", fecha_reg="
				+ fecha_reg + ", persona=" + persona + ", fotoscli=" + fotoscli + "]";
	}
	
	
}
