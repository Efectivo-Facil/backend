package com.Backend.Inmobiliaria.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "fotos_cli")
public class FotosCli {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_foto")
	private int id_foto;
	@Column(name = "url_foto")
	private String url_foto;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cli", referencedColumnName = "id_cli")
	private Cliente cliente;
	
}
