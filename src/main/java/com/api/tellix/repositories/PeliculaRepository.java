package com.api.tellix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.entities.Categoria;


@Repository
public interface PeliculaRepository extends BaseRepository <Pelicula, Long>{
    List<Pelicula> findByNombreContaining(String filtro);

    @Query(
        value = "select pelicula.* from pelicula where id in (select pelicula_id from pelicula_categoria where categoria_id = %:filtro%)",
        nativeQuery = true
    )
    List<Pelicula> findByCatID(Long filtro);

    
}
