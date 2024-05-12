package com.api.tellix.services;

import java.util.List;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.entities.Perfil;

public interface PerfilService extends BaseService<Perfil, Long>{
    List<Perfil> searchPerfil(Long filtro) throws Exception;
    boolean removeSerie(Long perfilID) throws Exception;
    boolean removePelicula(Long perfilID) throws Exception;
    boolean removeUsuFK(Long perfilID) throws Exception;
    List<Pelicula> searchFilms(Long perfilID) throws Exception;
    List<Pelicula> searchSeries(Long perfilID) throws Exception;
}
