package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Serie;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.SerieRepository;

import jakarta.transaction.Transactional;

@Service
public class SerieServiceImpl extends BaseServiceImpl<Serie, Long> implements SerieService{
    @Autowired
    private SerieRepository serieRepository;

    public SerieServiceImpl(BaseRepository<Serie, Long> baseRepository){
        super(baseRepository);
    }

    @Override
    @Transactional
    public List<Serie> findByCatID(Long filtro) throws Exception{
        try {
            List<Serie> series = serieRepository.findByCatID(filtro);
            return series;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Serie> findByName(String filtro) throws Exception{
        try{
            List<Serie> series = serieRepository.findByNombreContaining(filtro);
            return series; 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public int numTemporadas(Long filtro) throws Exception{
        try{
            int num = serieRepository.numTemporadas(filtro);
            return num;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
