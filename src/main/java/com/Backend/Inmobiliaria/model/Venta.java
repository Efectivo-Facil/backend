package com.Backend.Inmobiliaria.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="venta")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ven")
	private int id_ven;
	
	@Column(name = "fecha_ven")
	private Date fecha_ven;

	@Column(name = "monto_ven")
	private Double monto_ven;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "detalle_venta", 
			joinColumns = @JoinColumn(
					name = "id_ven", 
					referencedColumnName = "id_ven"), 
			
			inverseJoinColumns = @JoinColumn(
					name = "id_pro", 
					referencedColumnName = "id_pro"))
	
	private List<Producto> productos;
	
	@ManyToOne()
	@JoinColumn(name = "id_cli")
	private Cliente cliente;

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

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
