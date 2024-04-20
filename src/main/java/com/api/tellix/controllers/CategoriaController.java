package com.api.tellix.controllers;

import com.api.tellix.entities.Categoria;
import com.api.tellix.services.CategoriaServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl>{
    
    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreContaining(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
