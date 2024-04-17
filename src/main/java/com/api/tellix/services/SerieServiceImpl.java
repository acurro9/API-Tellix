package com.api.tellix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Serie;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.SerieRepository;

@Service
public class SerieServiceImpl extends BaseServiceImpl<Serie, Long> implements SerieService{
    @Autowired
    private SerieRepository serieRepository;

    public SerieServiceImpl(BaseRepository<Serie, Long> baseRepository){
        super(baseRepository);
    }
    
}
