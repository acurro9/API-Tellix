package com.api.tellix.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.tellix.entities.Pelicula;

public interface PeliculaService extends BaseService<Pelicula, Long>{
    List<Pelicula> findByCatID(Long filtro) throws Exception;
    Page<Pelicula> findByCatID(Long filtro, Pageable pageable) throws Exception;
    List<Pelicula> findByName(String filtro) throws Exception;
    Page<Pelicula> findByName(String filtro, Pageable pageable) throws Exception;
    boolean removeWatchlist(Long peliculaID) throws Exception;
    boolean removeCat(Long peliculaID) throws Exception;
    boolean addCat(Long peliculaID, Long categoriaID) throws Exception;
}
