package com.api.tellix.controllers;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.entities.Perfil;
import com.api.tellix.entities.Serie;
import com.api.tellix.services.PerfilServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private PeliculaController peliculaController;
    
    @Autowired
    private SerieController serieController;

    @GetMapping("/profiles")
    public ResponseEntity<?> searchPerfil(@RequestParam Long usuID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchPerfil(usuID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/watchList/films")
    public ResponseEntity<?> searchFilms(@RequestParam Long perfilID){
        try{
            Perfil perfil = servicio.findById(perfilID);
            return ResponseEntity.status(HttpStatus.OK).body(perfil.getPeliculas());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
    @GetMapping("/watchList/series")
    public ResponseEntity<?> searchSeries(@RequestParam Long perfilID){
        try{
            Perfil perfil = servicio.findById(perfilID);
            return ResponseEntity.status(HttpStatus.OK).body(perfil.getSeries());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

     @PostMapping("/watchList/change/film")
    public ResponseEntity<?> changeWatchListFilm(@RequestParam Long perfilID, @RequestParam Long peliculaID){
        try{
            Perfil perfil = servicio.findById(perfilID);
            Pelicula pelicula = peliculaController.servicio.findById(peliculaID);
            if(perfil.getPeliculas().contains(pelicula)){
                perfil.getPeliculas().remove(pelicula);
            } else {
                perfil.getPeliculas().add(pelicula);

            }
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(perfilID, perfil));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/watchList/change/serie")
    public ResponseEntity<?> changeWatchListSerie(@RequestParam Long perfilID, @RequestParam Long serieID){
        try{
            Perfil perfil = servicio.findById(perfilID);
            Serie serie = serieController.servicio.findById(serieID);
            if(perfil.getSeries().contains(serie)){
                perfil.getSeries().remove(serie);
            } else {
                perfil.getSeries().add(serie);
            }
            return ResponseEntity.status(HttpStatus.OK).body(servicio.update(perfilID, perfil));
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
