package com.Backend.Inmobiliaria.model;
import java.util.List;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name ="rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private int id_rol;
	
	@Column(name= "nombre_rol")
	private String nombre_rol;

	@Column(name= "activo_rol")
	private boolean activo_rol;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "rol_menu", 
			joinColumns = @JoinColumn(
					name = "id_rol", 
					referencedColumnName = "id_rol"), 
			
			inverseJoinColumns = @JoinColumn(
					name = "id_me", 
					referencedColumnName = "id_me"))
	
	private List<Menu> menus;
	
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public int getId_rol() {
		return id_rol;
	}

	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}

	public String getNombre_rol() {
		return nombre_rol;
	}

	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}

	public boolean getActivo_rol() {
		return activo_rol;
	}

	public void setActivo_rol(boolean activo_rol) {
		this.activo_rol = activo_rol;
	}
	
	
}
