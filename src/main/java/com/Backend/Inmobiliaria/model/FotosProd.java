package com.Backend.Inmobiliaria.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fotos_prod")
public class FotosProd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fot")
	private int id_fot;
	@Column(name = "url_foto") 
	private String url_foto;
	

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pro", referencedColumnName = "id_pro")
	private Producto producto;


	public int getId_fot() {
		return id_fot;
	}

	public void setId_fot(int id_fot) {
		this.id_fot = id_fot;
	}

	public String getUrl_foto() {
		return url_foto;
	}

	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}




	
	
}
