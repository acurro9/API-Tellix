package com.api.tellix.controllers;

import com.api.tellix.entities.Perfil;
import com.api.tellix.services.PerfilServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/perfiles")
public class PerfilController extends BaseControllerImpl<Perfil, PerfilServiceImpl>{
    
    @GetMapping("/profiles")
    public ResponseEntity<?> searchPerfil(@RequestParam Long usuID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPerfil(usuID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    
    @PostMapping("/watchList/add/serie")
    public ResponseEntity<?> addSerie(@RequestParam Long perfilID, @RequestParam Long serieID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addSerie(perfilID, serieID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @PostMapping("/watchList/delete/serie")
    public ResponseEntity<?> removeSerie(@RequestParam Long perfilID, @RequestParam Long serieID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.removeOneSerie(perfilID, serieID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/watchList/add/film")
    public ResponseEntity<?> addPelicula(@RequestParam Long perfilID, @RequestParam Long peliculaID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addPelicula(perfilID, peliculaID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/watchList/delete/film")
    public ResponseEntity<?> removePelicula(@RequestParam Long perfilID, @RequestParam Long peliculaID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.removeOnePelicula(perfilID, peliculaID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable Long id) {
         try{
            servicio.removeSerie(id);
            servicio.removePelicula(id);
            servicio.removeUsuFK(id);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
         } catch(Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
         }
     }
}
