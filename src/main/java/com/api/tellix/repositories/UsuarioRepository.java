package com.api.tellix.repositories;

import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository <Usuario, Long>{
    
    boolean existsByCorreo(String filtro);
}
