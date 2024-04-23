package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.PeliculaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PeliculaServiceImpl extends BaseServiceImpl<Pelicula, Long> implements PeliculaService{
    @Autowired
    private PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(BaseRepository<Pelicula, Long> baseRepository) {
        super(baseRepository);
    }
    
    @PersistenceContext
    private EntityManager entityManager;
    
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

    @Override
    @Transactional
    public boolean removeWatchlist(Long peliculaID) throws Exception {
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM watchlist_pelicula WHERE pelicula_id = ?")
        .setParameter(1, peliculaID)
        .executeUpdate();
        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }

    @Override
    @Transactional
    public boolean removeCat(Long peliculaID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM pelicula_categoria WHERE pelicula_id = ?")
        .setParameter(1, peliculaID)
        .executeUpdate();
        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }

    @Override
    @Transactional
    public boolean addCat(Long peliculaID, Long categoriaID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("INSERT INTO pelicula_categoria (pelicula_id, categoria_id) VALUES (?, ?)")
        .setParameter(1, peliculaID)
        .setParameter(2, categoriaID)
        .executeUpdate();
        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }
}
