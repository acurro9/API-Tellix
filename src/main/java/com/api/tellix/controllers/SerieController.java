package com.api.tellix.controllers;

import com.api.tellix.entities.Serie;
import com.api.tellix.services.SerieServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/series")
public class SerieController extends BaseControllerImpl<Serie, SerieServiceImpl>{
    
    @GetMapping("/searchCat")
    public ResponseEntity<?> findByID(@RequestParam Long filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByCatID(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> existsByName(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByName(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/temp")
    public ResponseEntity<?> numTemporadas(@RequestParam Long filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.numTemporadas(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
