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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/tellix/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl> {

    @Autowired
    private PerfilController perfilController;

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestParam String mail, @RequestParam String password){
        try{
            boolean existsCorreo = servicio.existsByCorreo(mail);
            if(existsCorreo){
                Usuario usuario = servicio.obtainUsu(mail);
                boolean checkPass = servicio.verifyPassword(password, usuario.getContraseña());
                if(checkPass){
                    boolean checkBloq = servicio.checkBloq(mail);
                    if(!checkBloq){
                        boolean checkSus = servicio.checkSus(mail);
                        if(checkSus){
                            return ResponseEntity.status(HttpStatus.OK).body(usuario);
                        } else {
                            return ResponseEntity.status(HttpStatus.OK).body("El usuario introducido no tiene una suscripción válida");
                        }
                    } else {
                        return ResponseEntity.status(HttpStatus.OK).body("El usuario introducido está bloqueado, por favor pongase en contacto con atención al cliente");
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body("La contraseña es incorrecta");
                }
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("El correo introducido no existe");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestParam String mail, @RequestParam String password){
        try{
            boolean existsCorreo = servicio.existsByCorreo(mail);
            if(existsCorreo){
                Usuario usuario = servicio.obtainUsu(mail);
                boolean checkPass = servicio.verifyPassword(password, usuario.getContraseña());
                if(checkPass){
                    boolean checkBloq = servicio.checkBloq(mail);
                    if(!checkBloq){
                        boolean checkSus = servicio.checkSus(mail);
                        if(checkSus){
                            if(usuario.isAdmin()){
                                return ResponseEntity.status(HttpStatus.OK).body(true);
                            } else {
                                return ResponseEntity.status(HttpStatus.OK).body("El usuario introducido no es administrador");
                            }
                        } else {
                            return ResponseEntity.status(HttpStatus.OK).body("El usuario introducido no tiene una suscripción válida");
                        }
                    } else {
                        return ResponseEntity.status(HttpStatus.OK).body("El usuario introducido está bloqueado, por favor pongase en contacto con atención al cliente");
                    }
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body("La contraseña es incorrecta");
                }
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("El correo introducido no existe");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @GetMapping("/mail/{mail}")
    public ResponseEntity<?> searchByCorreo(@PathVariable String mail){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.searchByCorreo(mail));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/")
     public ResponseEntity<?> save(@RequestBody Usuario entity) {
         try{
            boolean existsCorreo = servicio.existsByCorreo(entity.getCorreo());
            if (!existsCorreo){
                String password = entity.getContraseña();
                String hashPass = servicio.encryptPassword(password);
                entity.setContraseña(hashPass);
                Usuario usuario = servicio.save(entity); 
                Long idPerfil = servicio.crearPerfil(usuario.getNombre());
                Long idUsu = usuario.getId();
                boolean crearUsu = servicio.addPerfil(idUsu, idPerfil);
                 return ResponseEntity.status(HttpStatus.OK).body(crearUsu);
            } else { 
                return ResponseEntity.status(HttpStatus.OK).body("El correo introducido ya existe");
            }
            
         } catch(Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
         }
     }

     @PutMapping("/{id}")
     public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Usuario entity) {
         try{
            String password = entity.getContraseña();
            Usuario usuario = servicio.findById(id);
                String hashPass = servicio.encryptPassword(password);
                entity.setContraseña(hashPass);
             return ResponseEntity.status(HttpStatus.OK).body(servicio.update(id, entity));
         } catch(Exception e) {
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
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

    @PostMapping("/removePerfil")
    public ResponseEntity<?> removePerfil(@RequestParam Long perfilID){
        try{
            boolean resBorrar = servicio.removePerfil(perfilID);
            if(resBorrar){
                return ResponseEntity.status(HttpStatus.OK).body(perfilController.delete(perfilID));
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("Error al borrar el perfil");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

     @PostMapping("/bloq/{id}")
    public ResponseEntity<?> changeBloq(@PathVariable Long id){
        try{
            Usuario usuario = servicio.findById(id);
            boolean bloqueado = usuario.isBloqueado();
            return ResponseEntity.status(HttpStatus.OK).body(servicio.bloqUsu(id, !bloqueado));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"error\": \"" + e.getMessage() + "\"}"));
        }
    }

    @PostMapping("/suscription/{id}")
    public ResponseEntity<?> changeSus(@PathVariable Long id){
        try{
            Usuario usuario = servicio.findById(id);
            boolean suscripcion = usuario.isSuscripcion();
            return ResponseEntity.status(HttpStatus.OK).body(servicio.suscripcion(id, !suscripcion));
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
