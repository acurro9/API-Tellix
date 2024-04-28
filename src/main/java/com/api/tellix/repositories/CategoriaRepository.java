package com.api.tellix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Categoria;
import java.util.List;


@Repository
public interface CategoriaRepository extends BaseRepository <Categoria, Long>{

    List<Categoria> findByNombreContaining(String filtro);
    Page<Categoria> findByNombreContaining(String filtro, Pageable pageable);
    
}
