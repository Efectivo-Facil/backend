package com.Backend.Inmobiliaria.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Venta_PK implements Serializable{

	protected int id_ven; 
	protected Date fecha_ven;
	protected Double monto_ven;
	protected int id_cli;
	protected int id_pro;
	
	public int getId_ven() {
		return id_ven;
	}
	public void setId_ven(int id_ven) {
		this.id_ven = id_ven;
	}
	public Date getFecha_ven() {
		return fecha_ven;
	}
	public void setFecha_ven(Date fecha_ven) {
		this.fecha_ven = fecha_ven;
	}
	public Double getMonto_ven() {
		return monto_ven;
	}
	public void setMonto_ven(Double monto_ven) {
		this.monto_ven = monto_ven;
	}
	public int getId_cli() {
		return id_cli;
	}
	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}
	public int getId_pro() {
		return id_pro;
	}
	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id_cli, id_pro);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta_PK other = (Venta_PK) obj;
		return id_cli == other.id_cli && id_pro == other.id_pro;
	}
}
