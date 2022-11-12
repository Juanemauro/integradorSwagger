package com.example.demo.controller;

import java.util.List;

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

	@PostMapping("/estudiante")
	Estudiante matricularEstudiante(@RequestBody Estudiante e) {
		return service.addEstudiante(e);
	}
	
	@GetMapping("/estudiantes")
	public List<Estudiante>getEstudiantesByCriterioAsc(){
		return service.getEstudiantesByCriterio();
	}
	
	@GetMapping("/estudiante/{libreta}")
	public Estudiante getEstudianteByLibreta(@PathVariable int libreta) {
		return service.getEstudiante(libreta);
	}
	
	@GetMapping("/estudiantes/{genero}")
	public List<Estudiante>getEstudianteByGenero(@PathVariable String genero){
		return service.getGenero(genero);
	}
	
}
