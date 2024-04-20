package com.api.tellix.controllers;

import com.api.tellix.entities.Temporada;
import com.api.tellix.services.TemporadaServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/temporadas")
public class TemporadaController extends BaseControllerImpl<Temporada, TemporadaServiceImpl>{
    
    @GetMapping("/cap")
    public ResponseEntity<?> numTemporadas(@RequestParam Long filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.numCapitulos(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
