package com.api.tellix.services;

import java.util.List;
import com.api.tellix.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long>{
    boolean existsByCorreo(String filtro) throws Exception;
    List<Long> searchByUsuID(Long filtro) throws Exception; 
    Usuario searchByCorreo(String mail) throws Exception;
    boolean addPerfil(Long usuID, Long perfilID) throws Exception;
    Long crearPerfil(String nombre) throws Exception;
    boolean bloqUsu(Long id, boolean bloq) throws Exception;
    boolean suscripcion(Long id, boolean suscripcion) throws Exception;
    boolean checkBloq(String mail) throws Exception;
    boolean checkSus(String mail) throws Exception;
    Usuario obtainUsu(String mail) throws Exception;
    String encryptPassword(String password) throws Exception;
    boolean verifyPassword(String originalPassword, String hashPassword) throws Exception;
    boolean removePerfil(Long perfilID)throws Exception;
}
