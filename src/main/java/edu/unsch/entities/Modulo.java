package edu.unsch.entities;
// Generated Sep 30, 2020, 8:09:28 PM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modulo generated by hbm2java
 */
@Entity
@Table(name = "modulo", catalog = "evaluacion360")
public class Modulo implements java.io.Serializable {

	private Integer idmodulo;
	private String nombre;
	private String icono;
	private Byte estado;
	private Set<Submodulo> submodulos = new HashSet<Submodulo>(0);

	public Modulo() {
	}

	public Modulo(String nombre, String icono, Byte estado, Set<Submodulo> submodulos) {
		this.nombre = nombre;
		this.icono = icono;
		this.estado = estado;
		this.submodulos = submodulos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idmodulo", unique = true, nullable = false)
	public Integer getIdmodulo() {
		return this.idmodulo;
	}

	public void setIdmodulo(Integer idmodulo) {
		this.idmodulo = idmodulo;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "icono", length = 20)
	public String getIcono() {
		return this.icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	@Column(name = "estado")
	public Byte getEstado() {
		return this.estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "modulo")
	public Set<Submodulo> getSubmodulos() {
		return this.submodulos;
	}

	public void setSubmodulos(Set<Submodulo> submodulos) {
		this.submodulos = submodulos;
	}

}
