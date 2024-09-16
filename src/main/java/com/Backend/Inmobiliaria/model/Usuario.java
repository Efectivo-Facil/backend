package com.Backend.Inmobiliaria.model;

import java.util.List;

import org.hibernate.annotations.Cascade; 
import org.hibernate.annotations.CascadeType; 
import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usu")
	private int id_usu;
	@Column(name = "nom_usu")
	private String nom_usu;
	@Column(name = "pass_usu")
	private String pass_usu;
	@Column(name = "activo_usu")
	private boolean activo_usu;
	
	@ManyToOne(cascade = jakarta.persistence.CascadeType.ALL)
	@JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
	private Rol rol;
	
	@OneToOne
	@Cascade(CascadeType.ALL) 
	@JoinColumn(name="id_enc")
	private Encargado encargado;
	
	@OneToMany(mappedBy="usuario")
	private List<Movimiento> movimientos;

	public int getId_usu() {
		return id_usu;
	}

	public String getNom_usu() {
		return nom_usu;
	}

	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}

	public String getPass_usu() {
		return pass_usu;
	}

	public void setPass_usu(String pass_usu) {
		this.pass_usu = pass_usu;
	}

	public boolean isActivo_usu() {
		return activo_usu;
	}

	public void setActivo_usu(boolean activo_usu) {
		this.activo_usu = activo_usu;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Encargado getEncargado() {
		return encargado;
	}

	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}
	
}
