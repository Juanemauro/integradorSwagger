package com.example.demo.model.dto;

import java.time.LocalDate;
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
public class ReporteDTO {

	private String nombreCarrera;
	private LocalDate inscripcion;
	private Long cantGraduados;
	private Long cartInscriptos;
	
	public ReporteDTO(String nombreCarrera, LocalDate inscripcion, Long cantGraduados, Long cartInscriptos) {
		super();
		this.nombreCarrera = nombreCarrera;
		this.inscripcion = inscripcion;
		this.cantGraduados = cantGraduados;
		this.cartInscriptos = cartInscriptos;
	}

	public String getNombreCarrera() {
		return nombreCarrera;
	}

	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}

	public LocalDate getInscripcion() {
		return inscripcion;
	}

	public void setInscripcion(LocalDate inscripcion) {
		this.inscripcion = inscripcion;
	}

	public Long getCantGraduados() {
		return cantGraduados;
	}

	public void setCantGraduados(Long cantGraduados) {
		this.cantGraduados = cantGraduados;
	}

	public Long getCartInscriptos() {
		return cartInscriptos;
	}

	public void setCartInscriptos(Long cartInscriptos) {
		this.cartInscriptos = cartInscriptos;
	}

	@Override
	public String toString() {
		return "nombreCarrera=" + nombreCarrera + ", inscripcion=" + inscripcion + ", cantGraduados="
				+ cantGraduados + ", cartInscriptos=" + cartInscriptos;
	}
}
