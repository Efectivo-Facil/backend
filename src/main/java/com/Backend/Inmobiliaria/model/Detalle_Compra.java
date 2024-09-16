	package com.Backend.Inmobiliaria.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name ="detalle_compra")
public class Detalle_Compra {
	
	@EmbeddedId
	private DetalleCompraPK detPK;

	@ManyToOne
	 @MapsId("id_com")
	    @JoinColumn(name = "id_com")
	Compra compra;
	
	@ManyToOne
	 @MapsId("id_pro")
	    @JoinColumn(name = "id_pro")
	Producto producto;

	public DetalleCompraPK getDetPK() {
		return detPK;
	}

	public void setDetPK(DetalleCompraPK detPK) {
		this.detPK = detPK;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	


}
