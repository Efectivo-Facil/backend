package com.Backend.Inmobiliaria.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name ="detalle_venta")
public class Detalle_Venta {

	@EmbeddedId
	private DetalleVentaPK detPK;
	
	@ManyToOne
	 @MapsId("id_ven")
	    @JoinColumn(name = "id_ven")
	Venta venta;
	
	@ManyToOne
	 @MapsId("id_pro")
	    @JoinColumn(name = "id_pro")
	Producto producto;

	public DetalleVentaPK getDetPK() {
		return detPK;
	}

	public void setDetPK(DetalleVentaPK detPK) {
		this.detPK = detPK;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
