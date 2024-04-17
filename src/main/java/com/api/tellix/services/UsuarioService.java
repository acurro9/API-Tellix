package com.api.tellix.services;

import com.api.tellix.entities.Usuario;

public interface UsuarioService extends BaseService<Usuario, Long>{
    boolean existsByCorreo(String correo) throws Exception;
}
