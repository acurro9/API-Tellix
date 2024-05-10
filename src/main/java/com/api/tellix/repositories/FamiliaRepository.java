package com.api.tellix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Familia;
import java.util.List;


@Repository
public interface FamiliaRepository extends BaseRepository <Familia, Long>{

    List<Familia> findByNombreContaining(String filtro);
    Page<Familia> findByNombreContaining(String filtro, Pageable pageable);
    
}