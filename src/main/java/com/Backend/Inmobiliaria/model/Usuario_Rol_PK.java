package com.Backend.Inmobiliaria.model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario_Rol_PK implements Serializable{

	protected int id_usu;
	protected int id_rol;
	
	public int getId_usu() {
		return id_usu;
	}
	public void setId_usu(int id_usu) {
		this.id_usu = id_usu;
	}
	public int getId_rol() {
		return id_rol;
	}
	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_usu, id_rol);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario_Rol_PK other = (Usuario_Rol_PK) obj;
		return id_usu == other.id_usu && id_rol == other.id_rol;
	}
	
}
