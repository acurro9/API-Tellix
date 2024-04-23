package com.api.tellix.controllers;

import com.api.tellix.entities.Usuario;
import com.api.tellix.services.UsuarioServiceImpl;
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
@RequestMapping(path = "api/tellix/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    @Autowired
    private PerfilController perfilController;

    @GetMapping("/existsCorreo")
    public ResponseEntity<?> existsCorreo(@RequestParam String mail){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.existsByCorreo(mail));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/addPerfil")
    public ResponseEntity<?> addPerfil(@RequestParam Long usuID, @RequestParam Long perfilID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.addPerfil(usuID, perfilID));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<?> delete(@PathVariable Long id) {
         try{
            List<Long> perfiles = servicio.searchByUsuID(id);
            for (Long perfilID : perfiles) {
                perfilController.delete(perfilID);
            }
             return ResponseEntity.status(HttpStatus.NO_CONTENT).body(servicio.delete(id));
         } catch(Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
         }
     }
}
