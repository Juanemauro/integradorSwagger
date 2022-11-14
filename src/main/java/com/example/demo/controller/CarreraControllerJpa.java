package com.example.demo.controller;

import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Carrera;
import com.example.demo.services.CarreraService;

/**
 * @author <ul>
 *    <li>Johana Infesta</li>
 *    <li>Rocio Giannaccini</li>
 *    <li>Juan Mauro</li>
 *    <li>Juan Manuel Campo</li>
 *  </ul>
 */
@RestController
public class CarreraControllerJpa {

    @Qualifier("carreraService")
    @Autowired
    private final CarreraService service;

    public CarreraControllerJpa(@Qualifier("carreraService") CarreraService service) {
        this.service = service;
    }


	@Operation(summary = "Agregar una carrera")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Agregó la carrera",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = Carrera.class)) })})
    @PostMapping("/carrera")
    public Carrera agregarCarrera(@RequestBody Carrera c) {
        return service.addCarrera(c);
    }

    @Operation(summary = "Obtener una carrera por id de Carrera.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontró la carrera",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Carrera.class))})})
    @GetMapping("/carrera/{carreraID}")
    public Optional<Carrera> getCarrera(@PathVariable int carreraID) {
        return service.getCarrera(carreraID);
    }

}
