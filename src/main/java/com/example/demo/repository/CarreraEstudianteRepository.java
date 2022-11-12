package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Carrera;
import com.example.demo.model.CarreraEstudiante;
import com.example.demo.model.Estudiante;
import com.example.demo.model.dto.CarreraDTO;
import com.example.demo.model.dto.ReporteDTO;
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
@Repository
public interface CarreraEstudianteRepository extends JpaRepository<CarreraEstudiante, Integer>{

	@Query("SELECT new com.example.demo.model.dto.CarreraDTO(c.nombre, c.duracionAnios, Count(i)) " //se le puede agregar el count al select pero hay que hacer un DTO
			+ "FROM Carrera c JOIN c.inscripcion i "
			+ "GROUP BY c.carreraID "
			+ "ORDER BY count(i) DESC")
	public List<CarreraDTO>getCarrerasOrder();
	
	@Query("SELECT new com.example.demo.model.Estudiante(e.nombre, e.apellido, e.edad, e.genero, e.dni, e.ciudad) "
			+ "FROM Estudiante e "
			+ "JOIN e.inscripcion i "
			+ "WHERE e.ciudad= :ciudad AND i.carrera= :carrera")
	public List<Estudiante>getEstudianteCarrera(Carrera carrera, String ciudad);
	
	
	@Query("SELECT c FROM Carrera c WHERE c.carreraID= :carreraID")
	public Carrera getCarreraId(int carreraID);
	
	@Query("SELECT new com.example.demo.model.dto.ReporteDTO(c.nombre, i.inscripcion, COUNT(YEAR(i.graduado))AS cantGraduados, COUNT(YEAR(i.inscripcion))AS cantInscriptos) "
			+ "FROM Carrera c "
			+ "JOIN c.inscripcion i "
			+ "GROUP BY YEAR(i.inscripcion), c.carreraID "
			+ "ORDER BY c.nombre, i.inscripcion ASC")
	public List<ReporteDTO>getReporte();
	
}
