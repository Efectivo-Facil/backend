package com.Backend.Inmobiliaria.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class DetallePrestamoPK implements Serializable{
	
	protected int id_pres;
	protected int id_pro;
	
	public int getId_pres() {
		return id_pres;
	}
	public void setId_pres(int id_pres) {
		this.id_pres = id_pres;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_pres, id_pro);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetallePrestamoPK other = (DetallePrestamoPK) obj;
		return id_pres == other.id_pres && id_pro == other.id_pro;
	}
	
	

}
