package com.Backend.Inmobiliaria.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_pro")
	@GenericGenerator(name = "id_pro", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",  parameters = {
            @Parameter(name = "sequence_name", value = "id_pro"),
            @Parameter(name = "initial_value", value = "10"),
            @Parameter(name = "increment_size", value = "1")
    })
	private int id_pro; 
	
	@Column(name = "nombre_pro")
	private String nombre_pro;
	
	@Column(name = "desc_pro")
	private String desc_pro;
	
	@Column(name = "marca_pro")
	private String marca_pro;
	
	@Column(name = "modelo_pro")
	private String modelo_pro;

	@Column(name = "valor_inv")
	private Double valor_inv;

	@Column(name = "valor_sup")
	private Double valor_sup;

	@Column(name = "en_prenda")
	private boolean en_prenda;
	
	@Column(name = "activo_pro")
	private boolean activo_pro;
	
	@OneToMany(mappedBy="producto")
	private List<FotosProd> fotosprod;

	public int getId_pro() {
		return id_pro;
	}

	public Double getValor_sup() {
		return valor_sup;
	}

	public void setValor_sup(Double valor_sup) {
		this.valor_sup = valor_sup;
	}

	public void setId_pro(int id_pro) {
		this.id_pro = id_pro;
	}

	public String getNombre_pro() {
		return nombre_pro;
	}

	public void setNombre_pro(String nombre_pro) {
		this.nombre_pro = nombre_pro;
	}

	public String getDesc_pro() {
		return desc_pro;
	}

	public void setDesc_pro(String desc_pro) {
		this.desc_pro = desc_pro;
	}

	public String getMarca_pro() {
		return marca_pro;
	}

	public void setMarca_pro(String marca_pro) {
		this.marca_pro = marca_pro;
	}

	public String getModelo_pro() {
		return modelo_pro;
	}

	public void setModelo_pro(String modelo_pro) {
		this.modelo_pro = modelo_pro;
	}

	public Double getValor_inv() {
		return valor_inv;
	}

	public void setValor_inv(Double valor_inv) {
		this.valor_inv = valor_inv;
	}

	public boolean isEn_prenda() {
		return en_prenda;
	}

	public void setEn_prenda(boolean en_prenda) {
		this.en_prenda = en_prenda;
	}

	public boolean isActivo_pro() {
		return activo_pro;
	}

	public void setActivo_pro(boolean activo_pro) {
		this.activo_pro = activo_pro;
	}

	public List<FotosProd> getFotosprod() {
		return fotosprod;
	}

	public void setFotosprod(List<FotosProd> fotosprod) {
		this.fotosprod = fotosprod;
	}

	@Override
	public String toString() {
		return "Producto [id_pro=" + id_pro + ", nombre_pro=" + nombre_pro + ", desc_pro=" + desc_pro + ", marca_pro="
				+ marca_pro + ", modelo_pro=" + modelo_pro + ", valor_inv=" + valor_inv + ", en_prenda=" + en_prenda
				+ ", activo_pro=" + activo_pro + "]";
	}

}
