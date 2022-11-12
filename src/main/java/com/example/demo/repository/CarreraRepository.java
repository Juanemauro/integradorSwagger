package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Carrera;
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
public interface CarreraRepository extends JpaRepository<Carrera, Integer>{

	@Query("SELECT c FROM Carrera c WHERE c.carreraID= :carreraID")
	public Iterable<Carrera> getCarreraById(int carreraID);
	
	
}
