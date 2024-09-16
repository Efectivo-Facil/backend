package com.Backend.Inmobiliaria.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Compra_PK implements Serializable{

	protected int id_com; 
	protected Date fecha_com;
	protected Double monto_com;
	protected int id_cli;
	protected int id_pro;
	
	public int getId_com() {
		return id_com;
	}
	public void setId_com(int id_com) {
		this.id_com = id_com;
	}
	public Date getFecha_com() {
		return fecha_com;
	}
	public void setFecha_com(Date fecha_com) {
		this.fecha_com = fecha_com;
	}
	public Double getMonto_com() {
		return monto_com;
	}
	public void setMonto_com(Double monto_com) {
		this.monto_com = monto_com;
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
		Compra_PK other = (Compra_PK) obj;
		return id_cli == other.id_cli && id_pro == other.id_pro;
	}
}
