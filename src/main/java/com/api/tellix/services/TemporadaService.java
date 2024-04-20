package com.api.tellix.services;

import com.api.tellix.entities.Temporada;

public interface TemporadaService extends BaseService<Temporada, Long>{
    
    int numCapitulos(Long filtro) throws Exception;
}
