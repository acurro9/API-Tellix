package com.api.tellix.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.tellix.entities.Familia;

public interface FamiliaService extends BaseService<Familia, Long>{
    List<Familia> findByNombreContaining(String filtro) throws Exception;
    Page<Familia> findByNombreContaining(String filtro, Pageable pageable) throws Exception;
    boolean removeCont(Long famID) throws Exception;
    Long searchByFilmID(Long filmID) throws Exception;
    Long searchBySerieID(Long serieID) throws Exception;
    List<Long> filmIDs(Long famID) throws Exception;
    List<Long> serieIDs(Long famID) throws Exception;
}

