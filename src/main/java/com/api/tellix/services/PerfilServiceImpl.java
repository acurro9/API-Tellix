package com.api.tellix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Perfil;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.PeliculaRepository;

@Service
public class PerfilServiceImpl extends BaseServiceImpl<Perfil, Long> implements PerfilService{
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PerfilServiceImpl(BaseRepository<Perfil, Long> baseRepository) {
        super(baseRepository);
    }
}
