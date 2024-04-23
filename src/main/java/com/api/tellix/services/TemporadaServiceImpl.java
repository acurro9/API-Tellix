package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Temporada;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.TemporadaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class TemporadaServiceImpl extends BaseServiceImpl<Temporada, Long> implements TemporadaService{
    @Autowired
    private TemporadaRepository temporadaRepository;

    public TemporadaServiceImpl(BaseRepository<Temporada, Long> baseRepository){
        super(baseRepository);
    }

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public int numCapitulos(Long filtro) throws Exception{
        try{
            int num = temporadaRepository.numCapitulos(filtro);
            return num;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Long> searchByTempID(Long filtro) throws Exception{
        try {
            List<Long> temp = temporadaRepository.searchByTempID(filtro);
            return temp;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean addCap(Long tempID, Long capID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("UPDATE capitulo SET fk_temporada = ? WHERE id = ?")
        .setParameter(1, tempID)
        .setParameter(2, capID)
        .executeUpdate();
        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }
}
