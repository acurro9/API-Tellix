package com.api.tellix.services;

import java.util.List;
import com.api.tellix.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long>{
    boolean existsByCorreo(String filtro) throws Exception;
    List<Long> searchByUsuID(Long filtro) throws Exception; 
    boolean addPerfil(Long usuID, Long perfilID) throws Exception;
}
