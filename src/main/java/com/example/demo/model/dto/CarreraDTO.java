package com.example.demo.model.dto;
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
public class CarreraDTO {

private String nombre;
	
	private int duracionAnios;
	
	private Long cantInscriptos;

	public CarreraDTO(String nombre, int duracionAnios, Long cantInscriptos) {
		this.nombre = nombre;
		this.duracionAnios = duracionAnios;
		this.cantInscriptos = cantInscriptos;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDuracionAnios() {
		return duracionAnios;
	}

	public Long getCantInscriptos() {
		return cantInscriptos;
	}

	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDuracionAnios(int duracionAnios) {
		this.duracionAnios = duracionAnios;
	}

	public void setCantInscriptos(Long cantInscriptos) {
		this.cantInscriptos = cantInscriptos;
	}

	@Override
	public String toString() {
		return "nombre=" + nombre + ", duracionAnios=" + duracionAnios + ", cantInscriptos="
				+ cantInscriptos;
	} 
}
