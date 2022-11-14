package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Carrera;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Estudiante;
import com.example.demo.services.EstudianteService;
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
public class EstudianteControllerJpa {

	@Qualifier("estudianteService")
	@Autowired
	private EstudianteService service;
	
	public EstudianteControllerJpa(@Qualifier("estudianteService")EstudianteService service) {
		super();
		this.service = service;
	}

	@Operation(summary = "Agregar un estudiante")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Agregó el estudiante",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = Estudiante.class)) })})
	@PostMapping("/estudiante")
	public Estudiante matricularEstudiante(@RequestBody Estudiante e) {
		return service.addEstudiante(e);
	}

	@Operation(summary = "Obtener el listado de estudiantes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se obtuvo la lista de estudiantes",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = Estudiante.class))})})
	@GetMapping("/estudiantes")
	public List<Estudiante>getEstudiantesByCriterioAsc(){
		return service.getEstudiantesByCriterio();
	}

	@Operation(summary = "Obtener un estudiante por id de libreta.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se encontró al estudiante.",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = Estudiante.class))})})
	@GetMapping("/estudiante/{libreta}")
	public Estudiante getEstudianteByLibreta(@PathVariable int libreta) {
		return service.getEstudiante(libreta);
	}

	@Operation(summary = "Obtener un listado de estudiantes por género.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se obtuvo la lista de estudiantes.",
					content = {@Content(mediaType = "application/json",
							schema = @Schema(implementation = Estudiante.class))})})
	@GetMapping("/estudiantes/{genero}")
	public List<Estudiante>getEstudianteByGenero(@PathVariable String genero){
		return service.getGenero(genero);
	}
	
}
