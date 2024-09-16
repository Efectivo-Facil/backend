package com.Backend.Inmobiliaria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movimientos")
public class Movimientos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_mov")
	private int id_mov;
	@Column(name = "tipo_aporte")
	private String tipo_aporte;
	@Column(name = "concepto")
	private String concepto;
	@Column(name = "monto_mov")
	private float monto_mov;
	@Column(name = "fecha_mov")
	private Date fecha_mov;

	@OneToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	public int getId_mov() {
		return id_mov;
	}

	public void setId_mov(int id_mov) {
		this.id_mov = id_mov;
	}

	public String getTipo_aporte() {
		return tipo_aporte;
	}

	public void setTipo_aporte(String tipo_aporte) {
		this.tipo_aporte = tipo_aporte;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public float getMonto_mov() {
		return monto_mov;
	}

	public void setMonto_mov(float monto_mov) {
		this.monto_mov = monto_mov;
	}

	public Date getFecha_mov() {
		return fecha_mov;
	}

	public void setFecha_mov(Date fecha_mov) {
		this.fecha_mov = fecha_mov;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
