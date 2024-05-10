package com.api.tellix.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.tellix.entities.Serie;

public interface SerieService extends BaseService<Serie, Long>{
    List<Serie> findByCatID(Long filtro) throws Exception;
    Page<Serie> findByCatID(Long filtro, Pageable pageable) throws Exception;
    List<Serie> findByName(String filtro) throws Exception;
    Page<Serie> findByName(String filtro, Pageable pageable) throws Exception;
    int numTemporadas(Long filtro) throws Exception;
    List<Long> searchBySerieID(Long filtro) throws Exception;
    boolean removeWatchlist(Long peliculaID) throws Exception;
    boolean removeCat(Long serieID) throws Exception;
    boolean addCat(Long peliculaID, Long categoriaID) throws Exception;
    boolean addTemp(Long serieID, Long tempID) throws Exception;
    boolean removeFam(Long serieID) throws Exception;
    boolean addFam(Long familiaID, Long serieID)throws Exception;
}
