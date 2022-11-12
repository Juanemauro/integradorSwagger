package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Carrera;
import com.example.demo.model.CarreraEstudiante;
import com.example.demo.model.Estudiante;
import com.example.demo.model.dto.CarreraDTO;
import com.example.demo.model.dto.ReporteDTO;
import com.example.demo.repository.CarreraEstudianteRepository;
import com.example.demo.repository.EstudianteRepository;
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
@Service
public class CarreraEstudianteService {

	@Qualifier("carreraEstudianteRepository")
	@Autowired
	private CarreraEstudianteRepository repository;
	private EstudianteRepository estudianteRepository;

	public CarreraEstudianteService(@Qualifier("carreraEstudianteRepository") CarreraEstudianteRepository repository, EstudianteRepository estudianteRepository) {
		this.repository = repository;
		this.estudianteRepository = estudianteRepository;
	}
	/**
	 * 2 b) matricular un estudiante en una carrera
	 * @param libreta
	 * @param carreraID
	 * @return estudiante con carrera inscripto
	 */
	public CarreraEstudiante matricularEstudiante(int libreta, int carreraID) {
		Carrera carrera = repository.getCarreraId(carreraID);
		Estudiante estudiante = estudianteRepository.getEstudianteById(libreta);
		CarreraEstudiante ce = new CarreraEstudiante(carrera, estudiante, LocalDate.now(), null);
		return repository.save(ce);
	}

	/**
	 * 2 f) recuperar las carreras con estudiantes inscriptos, y ordenar por
	 * cantidad de inscriptos.
	 * 
	 * @return
	 */
	public List<CarreraDTO> getCarrerasInOrder() {
		return repository.getCarrerasOrder();
	}

	/**
	 * 2 g) recuperar los estudiantes de una determinada carrera, filtrado por
	 * ciudad de residencia.
	 * 
	 * @param carreraID
	 * @param ciudad
	 * @return lista de estudiantes de una carrera por ciudad
	 */
	public List<Estudiante> getEstudiantesCarrera(int carreraID, String ciudad) {
		Carrera carrera = repository.getCarreraId(carreraID);
		return repository.getEstudianteCarrera(carrera, ciudad);
	}

	/**
	 * 2 h) generar un reporte de las carreras, que para cada carrera incluya
	 * información de los inscriptos y egresados por año. Se deben ordenar las
	 * carreras alfabéticamente, y presentar los años de manera cronológica.
	 * @return reporte solicitado
	 */
	public List<ReporteDTO> generarReporte() {
		return repository.getReporte();
	}
}
