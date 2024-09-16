package com.Backend.Inmobiliaria.model;

import java.io.Serializable;
import java.util.Objects;

public class DetalleCompraPK implements Serializable{

	protected int id_com;
	protected int id_pro;
	
	public int getId_com() {
		return id_com;
	}
	public void setId_com(int id_com) {
		this.id_com = id_com;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_com, id_pro);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleCompraPK other = (DetalleCompraPK) obj;
		return id_com == other.id_com && id_pro == other.id_pro;
	}
	
	
	
	
}
