package com.api.tellix.controllers;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.services.PeliculaServiceImpl;

import org.springframework.data.domain.Pageable;
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
@RequestMapping(path = "api/tellix/peliculas")
public class PeliculaController extends BaseControllerImpl<Pelicula, PeliculaServiceImpl>{
    
    @GetMapping("/searchCat")
    public ResponseEntity<?> searchByCat(@RequestParam Long catID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByCatID(catID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchCat/paged")
    public ResponseEntity<?> searchByCat(@RequestParam Long catID, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByCatID(catID, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> existsByName(@RequestParam String name){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByName(name));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/paged")
    public ResponseEntity<?> existsByName(@RequestParam String name, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByName(name, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable Long id) {
         try{
            servicio.removeWatchlist(id);
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
         } catch(Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
         }
     }

     @PostMapping("/addCat")
    public ResponseEntity<?> addCategoria(@RequestParam Long peliculaID, @RequestParam Long catID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addCat(peliculaID, catID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
