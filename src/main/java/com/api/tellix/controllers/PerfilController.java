package com.api.tellix.controllers;

import com.api.tellix.entities.Perfil;
import com.api.tellix.services.PerfilServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/perfiles")
public class PerfilController extends BaseControllerImpl<Perfil, PerfilServiceImpl>{
    
    @GetMapping("/profiles")
    public ResponseEntity<?> searchPerfil(@RequestParam Long filtro){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPerfil(filtro));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    
    // @PutMapping("/addWatchList/{id}")
    // public ResponseEntity<?> addWatchList(@PathVariable Long id, @RequestBody Perfil perfil){
    //     try{
    //         return ResponseEntity.status(HttpStatus.OK).body(servicio.addWatchList(id, perfil));
    //     } catch(Exception e) {
    //         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    //     }
    // }
}
