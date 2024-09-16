package com.Backend.Inmobiliaria.model;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "prestamo")
public class Prestamo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_pres")
	@GenericGenerator(name = "id_pres", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",  parameters = {
            @Parameter(name = "sequence_name", value = "id_pres"),
            @Parameter(name = "initial_value", value = "10"),
            @Parameter(name = "increment_size", value = "1")
    })
	
	private int id_pres;
	@Column(name = "fecha_crea")
	private Date fechacrea;
	@Column(name = "fecha_ini")
	private Date fechaini;
	@Column(name = "fecha_fin")
	private Date fechafin;
	@Column(name = "fecha_fin_ini")
	private Date fechafinini;
	@Column(name = "fecha_ven")
	private Date fechaven;
	@Column(name = "monto")
	private double monto;
	@Column(name = "monto_ini")
	private double montoini;
	@Column(name = "monto_tot")
	private double monto_tot;
	@Column(name = "activo_pres")
	private boolean activo;
	@Column(name = "plazo_pres")
	private int plazo_pres;
	@Column(name = "plazo_pres_ini")
	private int plazo_pres_ini;
	@Column(name = "monto_int")
	private float monto_int;
	@Column(name = "periodo_pres")
	private int periodo_pres;

	@ManyToOne()
	@JoinColumn(name = "id_cli")
	private Cliente cliente;
	
	@OneToOne(mappedBy="prestamo")
	private Desempeño desempeño;
	
	@OneToOne(mappedBy="prestamo")
	private Remate remate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "detalle_prestamo", 
			joinColumns = @JoinColumn(
					name = "id_pres", 
					referencedColumnName = "id_pres"), 
			
			inverseJoinColumns = @JoinColumn(
					name = "id_pro", 
					referencedColumnName = "id_pro"))
	
	private List<Producto> productos;
	
	@OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL)
	private List<Recarga> recargas;

	@OneToMany(mappedBy = "prestamo", cascade = CascadeType.ALL)
	private List<Ampliacion> ampliaciones;
	
	public double getMontoini() {
		return montoini;
	}

	public void setMontoini(double montoini) {
		this.montoini = montoini;
	}

	public int getPlazo_pres_ini() {
		return plazo_pres_ini;
	}

	public void setPlazo_pres_ini(int plazo_pres_ini) {
		this.plazo_pres_ini = plazo_pres_ini;
	}

	public Date getFechafinini() {
		return fechafinini;
	}

	public void setFechafinini(Date fechafinini) {
		this.fechafinini = fechafinini;
	}

	public Date getFechacrea() {
		return fechacrea;
	}

	public void setFechacrea(Date fechacrea) {
		this.fechacrea = fechacrea;
	}

	public Date getFechaven() {
		return fechaven;
	}

	public void setFechaven(Date fechaven) {
		this.fechaven = fechaven;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public int getPlazo_pres() {
		return plazo_pres;
	}

	public void setPlazo_pres(int plazo_pres) {
		this.plazo_pres = plazo_pres;
	}

	public float getMonto_int() {
		return monto_int;
	}

	public void setMonto_int(float monto_int) {
		this.monto_int = monto_int;
	}

	public int getPeriodo_pres() {
		return periodo_pres;
	}

	public void setPeriodo_pres(int periodo_pres) {
		this.periodo_pres = periodo_pres;
	}

	public void setId_pres(int id_pres) {
		this.id_pres = id_pres;
	}

	public int getId_pres() {
		return id_pres;
	}

	public Date getFechaini() {
		return fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getMonto_tot() {
		return monto_tot;
	}

	public void setMonto_tot(double monto_tot) {
		this.monto_tot = monto_tot;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Recarga> getRecargas() {
		return recargas;
	}

	public void setRecargas(List<Recarga> recargas) {
		this.recargas = recargas;
	}

	public List<Ampliacion> getAmpliaciones() {
		return ampliaciones;
	}

	public void setAmpliaciones(List<Ampliacion> ampliaciones) {
		this.ampliaciones = ampliaciones;
	}

	@Override
	public String toString() {
		return "Prestamo [id_pres=" + id_pres + ", fechaini=" + fechaini + ", fechafin=" + fechafin + ", monto=" + monto
				+ ", monto_tot=" + monto_tot + ", activo=" + activo + ", plazo_pres=" + plazo_pres + ", monto_int="
				+ monto_int + ", periodo_pres=" + periodo_pres + ", cliente=" + cliente + ", desempeño=" + desempeño
				+ ", remate=" + remate + ", productos=" + productos + ", recargas=" + recargas + ", ampliaciones="
				+ ampliaciones + "]";
	}
	

}
