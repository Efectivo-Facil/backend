package com.Backend.Inmobiliaria.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name ="rol_menu")
public class Rol_Menu {

	@EmbeddedId
	private Rol_Menu_PK rmPK;
	
	 @ManyToOne
	 @MapsId("id_rol")
	    @JoinColumn(name = "id_rol")
	     Rol rol;
	 
	 @ManyToOne
	 @MapsId("id_me")
	    @JoinColumn(name = "id_me")
	     Menu menu;

	public Rol getRol() {
		return rol;
	}

	public Menu getMenu() {
		return menu;
	}
	
	   
}
