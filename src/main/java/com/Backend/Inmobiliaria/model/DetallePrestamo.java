package com.Backend.Inmobiliaria.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name ="detalle_prestamo")
public class DetallePrestamo {

	@EmbeddedId
	private DetallePrestamoPK detPK;
	
	@ManyToOne
	 @MapsId("id_pres")
	    @JoinColumn(name = "id_pres")
	Prestamo prestamo;
	
	@ManyToOne
	 @MapsId("id_pro")
	    @JoinColumn(name = "id_pro")
	Producto producto;

	public DetallePrestamoPK getDetPK() {
		return detPK;
	}

	public void setDetPK(DetallePrestamoPK detPK) {
		this.detPK = detPK;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
