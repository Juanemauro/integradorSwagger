package com.example.demo.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CarreraEstudiante;
import com.example.demo.model.Estudiante;
import com.example.demo.model.dto.CarreraDTO;
import com.example.demo.model.dto.ReporteDTO;
import com.example.demo.services.CarreraEstudianteService;
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
@RestController
public class CarreraEstudianteControllerJpa {

	@Qualifier("carreraEstudianteService")
	@Autowired
	private final CarreraEstudianteService service;


	public CarreraEstudianteControllerJpa(@Qualifier("carreraEstudianteService")CarreraEstudianteService service) {
		this.service = service;
	}
	@Operation(summary = "Agregar un estudiante a una carrera dada")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Agregó el estudiante",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = CarreraEstudiante.class)) })})
	@PostMapping("matricular/{libreta}/{carreraID}")
	public CarreraEstudiante matricularEstudiante(@PathVariable int libreta, @PathVariable int carreraID) {
		return service.matricularEstudiante(libreta, carreraID);
	}

	@Operation(summary = "Obtener el listado de carreras ordenadas.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se obtuvo la lista de carreras.",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = CarreraDTO.class))})})
	@GetMapping("/carreras")
	public List<CarreraDTO>getCarrerasOrder(){
		return service.getCarrerasInOrder();
	}

	@Operation(summary = "Obtener el listado de una carrera dada en una ciudad")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se obtuvo el listado de carreras.",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = CarreraDTO.class))})})
	@GetMapping("/estudiantes/{carreraID}/{ciudad}")
	public List<Estudiante>getEstudiantesCarrerasByCiudad(@PathVariable int carreraID, @PathVariable String ciudad){
		System.out.println(carreraID);
		return service.getEstudiantesCarrera(carreraID, ciudad);
	}

	@Operation(summary = "Obtener reporte de carreras con sus incripstos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se obtuvo el reporte",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = CarreraDTO.class))})})
	@GetMapping("/reporte")
	public List<ReporteDTO>getReporte(){
		return service.generarReporte();
	}

}
