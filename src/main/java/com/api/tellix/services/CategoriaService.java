package com.api.tellix.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.api.tellix.entities.Categoria;

public interface CategoriaService extends BaseService<Categoria, Long>{
    List<Categoria> findByNombreContaining(String filtro) throws Exception;
    Page<Categoria> findByNombreContaining(String filtro, Pageable pageable) throws Exception;
    boolean removeCont(Long catID) throws Exception;
}
