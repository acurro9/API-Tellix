package com.api.tellix.controllers;

import com.api.tellix.entities.Serie;
import com.api.tellix.services.SerieServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(path = "api/tellix/series")
public class SerieController extends BaseControllerImpl<Serie, SerieServiceImpl>{
    @Autowired
    private TemporadaController temporadaController;

    @GetMapping("/searchCat")
    public ResponseEntity<?> findByID(@RequestParam Long catID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.findByCatID(catID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/searchCat/paged")
    public ResponseEntity<?> findByID(@RequestParam Long catID, Pageable pageable){
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

    @GetMapping("/temp")
    public ResponseEntity<?> numTemporadas(@RequestParam Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.numTemporadas(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable Long id) {
         try{
            servicio.removeWatchlist(id);
            servicio.removeCat(id);
            servicio.removeFam(id);
            List<Long> temporadas = servicio.searchBySerieID(id);
            for (Long tempID : temporadas) {
                temporadaController.delete(tempID);
            }
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
         } catch(Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
         }
     }

    @PostMapping("/addCat")
    public ResponseEntity<?> addCategoria(@RequestParam Long serieID, @RequestParam Long catID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addCat(serieID, catID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/addTemp")
    public ResponseEntity<?> addTemporada(@RequestParam Long serieID, @RequestParam Long temporadaID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addTemp(serieID, temporadaID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/addFam")
    public ResponseEntity<?> addFamilia(@RequestParam Long serieID, @RequestParam Long famID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addFam(serieID, famID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
