package com.example.demo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Carrera;
import com.example.demo.model.Estudiante;
import com.example.demo.repository.CarreraRepository;
import com.example.demo.repository.EstudianteRepository;

import lombok.extern.slf4j.Slf4j;
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
@Configuration
@Slf4j
public class LoadDatabase {

private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);
	
//Correr con MySQL 
//conexion hecha en resources application.properties

	@Bean
	CommandLineRunner initEstudiante(@Qualifier("estudianteRepository") EstudianteRepository repository) {
		return args -> {
			logger.info("preloading" + repository.save(new Estudiante("Seba", "Perez", 20, "masculino", 40520425, "Olavarria")));
			logger.info("preloading" + repository.save(new Estudiante("Juan", "Lopez", 20, "masculino", 40100410, "Tandil")));
			logger.info("preloading" + repository.save(new Estudiante("Johana", "Infesta", 31, "femenino", 35580050, "Tandil")));
		};
	}
	
	
	@Bean
	CommandLineRunner initCarrera(@Qualifier("carreraRepository") CarreraRepository repository) {
		return args -> {
			logger.info("preloading" + repository.save(new Carrera("TUDAI", 3)));
			logger.info("preloading" + repository.save(new Carrera("TUARI", 3)));
			logger.info("preloading" + repository.save(new Carrera("Ingenieria en Sistemas", 5)));
		};
	}
}
