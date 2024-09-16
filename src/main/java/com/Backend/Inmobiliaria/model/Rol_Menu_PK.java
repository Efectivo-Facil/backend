package com.Backend.Inmobiliaria.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class Rol_Menu_PK implements Serializable{

	protected int id_me;
	protected int id_rol;
	
	public int getId_me() {
		return id_me;
	}
	public void setId_me(int id_me) {
		this.id_me = id_me;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_me, id_rol);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol_Menu_PK other = (Rol_Menu_PK) obj;
		return id_me == other.id_me && id_rol == other.id_rol;
	}
}
