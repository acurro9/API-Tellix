package com.api.tellix.services;

import java.util.List;

import com.api.tellix.entities.Perfil;

public interface PerfilService extends BaseService<Perfil, Long>{
    // Perfil addFilm(Long id, Perfil perfil) throws Exception;
    List<Perfil> searchPerfil(Long filtro) throws Exception;
}
