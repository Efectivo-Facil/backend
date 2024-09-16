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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_com")
	private int id_com;
	
	@Column(name = "fecha_com")
	private Date fecha_com;

	@Column(name = "monto_com")
	private Double monto_com;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "detalle_compra", 
			joinColumns = @JoinColumn(
					name = "id_com", 
					referencedColumnName = "id_com"), 
			
			inverseJoinColumns = @JoinColumn(
					name = "id_pro", 
					referencedColumnName = "id_pro"))
	
	private List<Producto> productos;

	
	@ManyToOne()
	@JoinColumn(name = "id_cli")
	private Cliente cliente;
	
	
/*
	 @OneToOne
		@JoinColumn(name="id_pro")
		private Producto producto;
*/

	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


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


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
/*
	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}
*/


}
