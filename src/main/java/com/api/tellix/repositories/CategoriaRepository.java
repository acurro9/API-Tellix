package com.api.tellix.repositories;

import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Categoria;
import java.util.List;


@Repository
public interface CategoriaRepository extends BaseRepository <Categoria, Long>{

    List<Categoria> findByNombreContaining(String filtro);
    
}
