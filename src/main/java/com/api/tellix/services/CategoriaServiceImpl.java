package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Categoria;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.CategoriaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService{    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(BaseRepository<Categoria, Long> baseRepository) {
        super(baseRepository);
    }

    @PersistenceContext
    private EntityManager entityManager;

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

    @Override
    @Transactional
    public boolean removeCont(Long catID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM serie_categoria WHERE categoria_id = ?")
        .setParameter(1, catID)
        .executeUpdate();
        if(res == 1){
            int res2 = entityManager.createNativeQuery("DELETE FROM pelicula_categoria WHERE categoria_id = ?")
            .setParameter(1, catID)
            .executeUpdate();
            if(res2 == 1){
                resultado= true;
            } else {
                resultado = false;
            }
        } else{
            resultado = false;
        }
        return resultado;
    }
}
