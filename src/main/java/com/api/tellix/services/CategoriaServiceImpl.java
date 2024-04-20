package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Categoria;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.CategoriaRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService{    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(BaseRepository<Categoria, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Categoria> findByNombreContaining(String filtro) throws Exception{
        try {
            List<Categoria> categoria = categoriaRepository.findByNombreContaining(filtro);
            return categoria;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
