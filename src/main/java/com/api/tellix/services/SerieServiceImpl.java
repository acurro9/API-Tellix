package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Serie;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.SerieRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class SerieServiceImpl extends BaseServiceImpl<Serie, Long> implements SerieService{
    @Autowired
    private SerieRepository serieRepository;

    public SerieServiceImpl(BaseRepository<Serie, Long> baseRepository){
        super(baseRepository);
    }

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public List<Serie> findByCatID(Long filtro) throws Exception{
        try {
            List<Serie> series = serieRepository.findByCategorias_Id(filtro);
            return series;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Serie> findByCatID(Long filtro, Pageable pageable) throws Exception{
        try {
            Page<Serie> series = serieRepository.findByCategorias_Id(filtro, pageable);
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
    public Page<Serie> findByName(String filtro, Pageable pageable) throws Exception{
        try{
            Page<Serie> series = serieRepository.findByNombreContaining(filtro, pageable);
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

    @Override
    @Transactional
    public List<Long> searchBySerieID(Long filtro) throws Exception{
        try {
            List<Long> temp = serieRepository.searchBySerieID(filtro);
            return temp;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean removeWatchlist(Long serieID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM watchlist_serie WHERE serie_id = ?")
        .setParameter(1, serieID)
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
    public boolean removeCat(Long serieID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM serie_categoria WHERE serie_id = ?")
        .setParameter(1, serieID)
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
    public boolean addCat(Long serieID, Long categoriaID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("INSERT INTO serie_categoria (serie_id, categoria_id) VALUES (?, ?)")
        .setParameter(1, serieID)
        .setParameter(2, categoriaID)
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
    public boolean addTemp(Long serieID, Long tempID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("UPDATE temporada SET fk_serie = ? WHERE id = ?")
        .setParameter(1, serieID)
        .setParameter(2, tempID)
        .executeUpdate();
        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }
}
