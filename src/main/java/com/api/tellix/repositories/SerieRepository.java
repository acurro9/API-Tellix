package com.api.tellix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Serie;

@Repository
public interface SerieRepository extends BaseRepository <Serie, Long>{
    List<Serie> findByNombreContaining(String filtro);

    @Query(
        value = "select serie.* from serie where id in (select serie_id from serie_categoria where categoria_id = %:filtro%)",
        nativeQuery = true
    )
    List<Serie> findByCatID(Long filtro);

    @Query(
        value = "select count(*) from temporada where temporada.fk_serie = %:filtro%",
        nativeQuery = true
    )
    int numTemporadas(Long filtro);
}
