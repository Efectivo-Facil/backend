package com.Backend.Inmobiliaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_me")
	private int id_me;
	
	@Column(name= "nombre_me")
	private String nombre_me;

	@Column(name= "url_me")
	private String url_me;
	
	@Column(name= "activo_me")
	private boolean activo_me;

	public long getId_me() {
		return id_me;
	}

	public void setId_me(int id_me) {
		this.id_me = id_me;
	}

	public String getNombre_me() {
		return nombre_me;
	}

	public void setNombre_me(String nombre_me) {
		this.nombre_me = nombre_me;
	}

	public String getUrl_me() {
		return url_me;
	}

	public void setUrl_me(String url_me) {
		this.url_me = url_me;
	}

	public boolean getActivo_me() {
		return activo_me;
	}

	public void setActivo_me(boolean activo_me) {
		this.activo_me = activo_me;
	}
	

}
