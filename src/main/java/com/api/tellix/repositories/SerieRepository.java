package com.api.tellix.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Serie;

@Repository
public interface SerieRepository extends BaseRepository <Serie, Long>{
    List<Serie> findByNombreContaining(String filtro);
    Page<Serie> findByNombreContaining(String filtro, Pageable pageable);
    List<Serie> findByCategorias_Id(Long filtro);
    Page<Serie> findByCategorias_Id(Long filtro, Pageable pageable);

    @Query(
        value = "select count(*) from temporada where temporada.fk_serie = :filtro",
        nativeQuery = true
    )
    int numTemporadas(Long filtro);

    @Query(
        value = "select id from temporada where fk_serie = :filtro",
        nativeQuery = true
    )
    List<Long> searchBySerieID(Long filtro);
}
