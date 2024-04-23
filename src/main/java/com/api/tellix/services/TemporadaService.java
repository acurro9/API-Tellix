package com.api.tellix.services;

import java.util.List;

import com.api.tellix.entities.Temporada;

public interface TemporadaService extends BaseService<Temporada, Long>{
    
    int numCapitulos(Long filtro) throws Exception;
    List<Long> searchByTempID(Long filtro) throws Exception;
    boolean addCap(Long serieID, Long tempID) throws Exception;
}
