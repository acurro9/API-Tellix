package com.api.tellix.controllers;

import com.api.tellix.entities.Familia;
import com.api.tellix.services.FamiliaServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/familias")
public class FamiliaController extends BaseControllerImpl<Familia, FamiliaServiceImpl>{
    @Autowired
    private SerieController serieController;

    @Autowired
    private PeliculaController peliculaController;

    @GetMapping("/search")
    public ResponseEntity<?> findByName(@RequestParam String name){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreContaining(name));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/paged")
    public ResponseEntity<?> findByName(@RequestParam String name, Pageable pageable){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByNombreContaining(name, pageable));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/search/film/{filmID}")
    public ResponseEntity<?> findByFilm(@PathVariable Long filmID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByFilmID(filmID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/search/serie/{serieID}")
    public ResponseEntity<?> findBySerie(@PathVariable Long serieID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchBySerieID(serieID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try{
            List<Long> films = servicio.filmIDs(id);
            List<Long> series = servicio.serieIDs(id);
            servicio.removeCont(id);
            for (Long peliculaID : films) {
                peliculaController.delete(peliculaID);
            }
            for (Long serieID : series) {
                serieController.delete(serieID);
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}