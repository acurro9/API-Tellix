package com.api.tellix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.api.tellix.entities.Pelicula;


@Repository
public interface PeliculaRepository extends BaseRepository <Pelicula, Long>{
    List<Pelicula> findByNombreContaining(String filtro);
    Page<Pelicula> findByNombreContaining(String filtro, Pageable pageable);
    List<Pelicula> findByCategorias_Id(Long filtro);
    Page<Pelicula> findByCategorias_Id(Long filtro, Pageable pageable);
    
}
