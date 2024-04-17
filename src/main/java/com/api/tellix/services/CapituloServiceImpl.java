package com.api.tellix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Capitulo;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.CapituloRepository;

@Service
public class CapituloServiceImpl extends BaseServiceImpl<Capitulo, Long> implements CapituloService{
    @Autowired
    private CapituloRepository capituloRepository;

    public CapituloServiceImpl(BaseRepository<Capitulo, Long> baseRepository) {
        super(baseRepository);
    }
    
}
