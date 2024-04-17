package com.api.tellix.repositories;

import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Capitulo;

@Repository
public interface CapituloRepository extends BaseRepository <Capitulo, Long> {
    
}
