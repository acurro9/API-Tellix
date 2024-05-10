package com.api.tellix.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Familia;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.FamiliaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
public class FamiliaServiceImpl extends BaseServiceImpl<Familia, Long> implements FamiliaService{    
    @Autowired
    private FamiliaRepository FamiliaRepository;

    public FamiliaServiceImpl(BaseRepository<Familia, Long> baseRepository) {
        super(baseRepository);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Familia> findByNombreContaining(String filtro) throws Exception{
        try {
            List<Familia> Familia = FamiliaRepository.findByNombreContaining(filtro);
            return Familia;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Page<Familia> findByNombreContaining(String filtro, Pageable pageable) throws Exception{
        try {
            Page<Familia> Familia = FamiliaRepository.findByNombreContaining(filtro, pageable);
            return Familia;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Long searchByFilmID(Long filmID) throws Exception{
        try{
            int selectQuery = entityManager.createNativeQuery("SELECT * FROM familia where id = (SELECT familia_id FROM pelicula_familia WHERE pelicula_id = ?)")
            .setParameter(1, filmID)
            .executeUpdate();

            Long familiaId = (Long) entityManager.createNativeQuery("SELECT * FROM familia where id = (SELECT familia_id FROM pelicula_familia WHERE pelicula_id = ?)")
            .setParameter(1, filmID)
            .getSingleResult();
            return familiaId;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Long searchBySerieID(Long serieID) throws Exception{
        try{
            int selectQuery = entityManager.createNativeQuery("SELECT * FROM familia where id = (SELECT familia_id FROM serie_familia WHERE serie_id = ?)")
            .setParameter(1, serieID)
            .executeUpdate();

            Long familiaId = (Long) entityManager.createNativeQuery("SELECT * FROM familia where id = (SELECT familia_id FROM serie_familia WHERE serie_id = ?)")
            .setParameter(1, serieID)
            .getSingleResult();
            return familiaId;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean removeCont(Long famID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM serie_familia WHERE familia_id = ?")
        .setParameter(1, famID)
        .executeUpdate();
        if(res == 1){
            int res2 = entityManager.createNativeQuery("DELETE FROM pelicula_familia WHERE familia_id = ?")
            .setParameter(1, famID)
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

    @Override
    @Transactional
    public List<Long> filmIDs(Long famID) throws Exception{
        List<Long> filmIDs = new ArrayList<>();
        int res = entityManager.createNativeQuery("SELECT pelicula_id FROM pelicula_familia WHERE familia_id=?;")
        .setParameter(1, famID)
        .executeUpdate();
        if(res == 1){
            List<Long> resultados = entityManager.createNativeQuery("SELECT pelicula_id FROM pelicula_familia WHERE familia_id=?;")
            .setParameter(1, famID)
            .getResultList();

            filmIDs.addAll(resultados); // Agrega los ID a la lista
        }
        return filmIDs;
    }

    @Override
    @Transactional
    public List<Long> serieIDs(Long famID) throws Exception{
        List<Long> serieIDs = new ArrayList<>();
        int res = entityManager.createNativeQuery("SELECT serie_id FROM serie_familia WHERE familia_id=?;")
        .setParameter(1, famID)
        .executeUpdate();
        if(res == 1){
            List<Long> resultados = entityManager.createNativeQuery("SELECT serie_id FROM serie_familia WHERE familia_id=?;")
            .setParameter(1, famID)
            .getResultList();

            serieIDs.addAll(resultados); // Agrega los ID a la lista
        }
        return serieIDs;
    }
}
