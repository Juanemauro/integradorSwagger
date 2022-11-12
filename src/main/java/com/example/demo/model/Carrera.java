package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
/**
 * 
 * @author 
 * <ul>
 *    <li>Johana Infesta</li>
 *    <li>Rocio Giannaccini</li>
 *    <li>Juan Mauro</li>
 *    <li>Juan Manuel Campo</li>
 *  </ul>
 */
@Entity
@Data
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carreraID;
	
	@Column
	private String nombre;
	
	@JsonManagedReference
 	@OneToMany(mappedBy = "carrera", fetch=FetchType.LAZY)
	private List<CarreraEstudiante>inscripcion;
 	
 	@Column
 	private int duracionAnios;

	public Carrera() {
		super();
	}

	public Carrera(String nombre, int duracionAnios) {
		this.nombre = nombre;
		this.duracionAnios = duracionAnios;
	}

	public int getCarreraID() {
		return carreraID;
	}

	public String getNombre() {
		return nombre;
	}

	public List<CarreraEstudiante> getEstudiantes() {
		return inscripcion;
	}

	public int getDuracionAnios() {
		return duracionAnios;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", duracionAnios=" + duracionAnios + "]";
	}

	
 	
 	
}
