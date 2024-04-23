package com.api.tellix.services;

import java.util.List;

import com.api.tellix.entities.Serie;

public interface SerieService extends BaseService<Serie, Long>{
    List<Serie> findByCatID(Long filtro) throws Exception;
    List<Serie> findByName(String filtro) throws Exception;
    int numTemporadas(Long filtro) throws Exception;
    List<Long> searchBySerieID(Long filtro) throws Exception;
    boolean removeWatchlist(Long peliculaID) throws Exception;
    boolean removeCat(Long serieID) throws Exception;
    boolean addCat(Long peliculaID, Long categoriaID) throws Exception;
    boolean addTemp(Long serieID, Long tempID) throws Exception;
}
