package com.api.tellix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Temporada;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.TemporadaRepository;

import jakarta.transaction.Transactional;

@Service
public class TemporadaServiceImpl extends BaseServiceImpl<Temporada, Long> implements TemporadaService{
    @Autowired
    private TemporadaRepository temporadaRepository;

    public TemporadaServiceImpl(BaseRepository<Temporada, Long> baseRepository){
        super(baseRepository);
    }

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
}
