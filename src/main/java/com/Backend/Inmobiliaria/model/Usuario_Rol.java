package com.Backend.Inmobiliaria.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name ="usuario_rol")
public class Usuario_Rol {

	@EmbeddedId
	private Usuario_Rol_PK rmPK;
	
	 @ManyToOne
	 @MapsId("id_usu")
	    @JoinColumn(name = "id_usu")
	     Usuario usuario;

	
	 @ManyToOne
	 @MapsId("id_rol")
	    @JoinColumn(name = "id_rol")
	     Rol rol;

	public Usuario getUsuario() {
		return usuario;
	}

	public Rol getRol() {
		return rol;
	}

	 
}
