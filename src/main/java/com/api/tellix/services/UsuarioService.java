package com.api.tellix.services;

import java.util.List;

import com.api.tellix.entities.Perfil;
import com.api.tellix.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long>{
    boolean existsByCorreo(String filtro) throws Exception;
}
