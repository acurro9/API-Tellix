package com.api.tellix.controllers;

import com.api.tellix.entities.Temporada;
import com.api.tellix.services.TemporadaServiceImpl;

import java.util.List;
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
@RequestMapping(path = "api/tellix/temporadas")
public class TemporadaController extends BaseControllerImpl<Temporada, TemporadaServiceImpl>{

    @Autowired
    private CapituloController capituloController;
    
    @GetMapping("/cap")
    public ResponseEntity<?> numTemporadas(@RequestParam Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.numCapitulos(id));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable Long id) {
         try{
            List<Long> capitulos = servicio.searchByTempID(id);
            for (Long capID : capitulos) {
                capituloController.delete(capID);
            }
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
         } catch(Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
         }
     }

     @PostMapping("/addChapter")
    public ResponseEntity<?> addCapitulo(@RequestParam Long temporadaID, @RequestParam Long capituloID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addCap(temporadaID, capituloID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }
}
