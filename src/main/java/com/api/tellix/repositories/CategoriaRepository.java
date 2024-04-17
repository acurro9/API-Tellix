package com.api.tellix.repositories;

import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Categoria;

@Repository
public interface CategoriaRepository extends BaseRepository <Categoria, Long>{
    
}
