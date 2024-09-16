package com.Backend.Inmobiliaria.model;

import java.io.Serializable;
import java.util.Objects;

public class DetalleVentaPK implements Serializable{

	protected int id_ven;
	protected int id_pro;
	
	public int getId_ven() {
		return id_ven;
	}
	public void setId_ven(int id_ven) {
		this.id_ven = id_ven;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_pro, id_ven);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetalleVentaPK other = (DetalleVentaPK) obj;
		return id_pro == other.id_pro && id_ven == other.id_ven;
	}
	
	
}
