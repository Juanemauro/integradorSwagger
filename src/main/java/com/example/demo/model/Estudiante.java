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
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private int libreta;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad; //Long
	@Column
	private String genero;
	@Column
	private int dni;
	
	@Column
	private String ciudad;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "estudiante", fetch=FetchType.LAZY)
	private List <CarreraEstudiante>inscripcion;

	public Estudiante() {
		super();
	}

	public Estudiante(String nombre, String apellido, int edad, String genero, int dni, String ciudad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.genero = genero;
		this.dni = dni;
		this.ciudad = ciudad;
	}

	public int getLibreta() {
		return libreta;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public String getGenero() {
		return genero;
	}

	public int getDni() {
		return dni;
	}

	public String getCiudad() {
		return ciudad;
	}

	public List<CarreraEstudiante> getCarreras() {
		return inscripcion;
	}
	

	@Override
	public String toString() {
		return "Estudiante [libreta=" + libreta + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", genero=" + genero + ", dni=" + dni + ", ciudad=" + ciudad + "]";
	}
	
	
	
	
}
