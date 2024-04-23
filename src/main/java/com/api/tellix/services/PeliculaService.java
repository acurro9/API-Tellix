package com.api.tellix.services;

import java.util.List;

import com.api.tellix.entities.Pelicula;

public interface PeliculaService extends BaseService<Pelicula, Long>{
    List<Pelicula> findByCatID(Long filtro) throws Exception;
    List<Pelicula> findByName(String filtro) throws Exception;
    boolean removeWatchlist(Long peliculaID) throws Exception;
    boolean removeCat(Long peliculaID) throws Exception;
    boolean addCat(Long peliculaID, Long categoriaID) throws Exception;
}
