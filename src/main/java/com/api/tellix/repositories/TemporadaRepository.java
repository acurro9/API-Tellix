package com.api.tellix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Temporada;

@Repository
public interface TemporadaRepository extends BaseRepository <Temporada, Long>{
    
    @Query(
        value = "select count(*) from capitulo where capitulo.fk_temporada = :filtro",
        nativeQuery = true
    )
    int numCapitulos(Long filtro);

    @Query(
        value = "select id from capitulo where fk_temporada = :filtro",
        nativeQuery = true
    )
    List<Long> searchByTempID(Long filtro);
}
