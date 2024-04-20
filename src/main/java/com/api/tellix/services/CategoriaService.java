package com.api.tellix.services;

import java.util.List;

import com.api.tellix.entities.Categoria;

public interface CategoriaService extends BaseService<Categoria, Long>{
    List<Categoria> findByNombreContaining(String filtro) throws Exception;
}
