package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.PeliculaRepository;

import jakarta.transaction.Transactional;

@Service
public class PeliculaServiceImpl extends BaseServiceImpl<Pelicula, Long> implements PeliculaService{
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(BaseRepository<Pelicula, Long> baseRepository) {
        super(baseRepository);
    }
    
    @Override
    @Transactional
    public List<Pelicula> findByCatID(Long filtro) throws Exception{
        try {
            List<Pelicula> peliculas = peliculaRepository.findByCatID(filtro);
            return peliculas;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Pelicula> findByName(String filtro) throws Exception{
        try{
            List<Pelicula> peliculas = peliculaRepository.findByNombreContaining(filtro);
            return peliculas; 
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
