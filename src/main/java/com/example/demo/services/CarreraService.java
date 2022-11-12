package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Carrera;
import com.example.demo.repository.CarreraRepository;
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
public class CarreraService {
	@Qualifier("carreraRepository")
	@Autowired
	private CarreraRepository repository;

	public CarreraService(@Qualifier("carreraRepository")CarreraRepository repository) {
		this.repository = repository;
	}

	public Carrera addCarrera(Carrera c) {
		return repository.save(c);
	}
	
	public Optional<Carrera> getCarrera(int id) {
		return repository.findById(id);
	}
	
}
