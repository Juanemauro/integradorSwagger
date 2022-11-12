package com.example.demo.model;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class CarreraEstudiante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_carrera", referencedColumnName="carreraID")
	private Carrera carrera;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_estudiante", referencedColumnName="libreta")
	private Estudiante estudiante;
	
	@Column
 	private LocalDate inscripcion;
	
	@Column(nullable = true)
	private Date graduado;

	public CarreraEstudiante() {
		super();
	}

	public CarreraEstudiante(Carrera carrera, Estudiante estudiante, LocalDate inscripcion, Date graduado) {
		super();
		this.carrera = carrera;
		this.estudiante = estudiante;
		this.inscripcion = inscripcion;
		this.graduado = graduado;
	}

	public int getId() {
		return id;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public LocalDate getInscripcion() {
		return inscripcion;
	}

	public Date getGraduado() {
		return graduado;
	}

	@Override
	public String toString() {
		return "CarreraEstudiante [carrera=" + carrera + ", estudiante=" + estudiante + ", inscripcion=" + inscripcion
				+ ", graduado=" + graduado + "]";
	}
	
	
	
}
