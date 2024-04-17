package com.api.tellix.repositories;

import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Pelicula;

@Repository
public interface PeliculaRepository extends BaseRepository <Pelicula, Long>{
    
}
