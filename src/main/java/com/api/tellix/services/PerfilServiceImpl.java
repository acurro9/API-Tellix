package com.api.tellix.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.tellix.entities.Perfil;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.PerfilRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PerfilServiceImpl extends BaseServiceImpl<Perfil, Long> implements PerfilService{
    @Autowired
    private PerfilRepository perfilRepository;

    public PerfilServiceImpl(BaseRepository<Perfil, Long> baseRepository) {
        super(baseRepository);
    }

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public List<Perfil> searchPerfil(Long filtro) throws Exception{
        try {
            List<Perfil> perfiles = perfilRepository.searchPerfil(filtro);
            return perfiles;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean addSerie(Long perfilID, Long serieID) {
        boolean resultado;
        int res = entityManager.createNativeQuery("INSERT INTO watchlist_serie (perfil_id, serie_id) VALUES (?, ?)")
        .setParameter(1, perfilID)
        .setParameter(2, serieID)
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
    public boolean removeSerie(Long perfilID) {
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM watchlist_serie WHERE perfil_id = ?")
        .setParameter(1, perfilID)
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
    public boolean removeOneSerie(Long perfilID, Long serieID) {
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM watchlist_serie WHERE perfil_id = ? and serie_id = ?")
        .setParameter(1, perfilID)
        .setParameter(2, serieID)
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
    public boolean addPelicula(Long perfilID, Long peliculaID) throws Exception{
        boolean resultado;
        int res = entityManager.createNativeQuery("INSERT INTO watchlist_pelicula (perfil_id, pelicula_id) VALUES (?, ?)")
        .setParameter(1, perfilID)
        .setParameter(2, peliculaID)
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
    public boolean removePelicula(Long perfilID) {
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM watchlist_pelicula WHERE perfil_id = ?")
        .setParameter(1, perfilID)
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
    public boolean removeOnePelicula(Long perfilID, Long peliculaID) {
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM watchlist_pelicula WHERE perfil_id = ? and pelicula_id = ?")
        .setParameter(1, perfilID)
        .setParameter(2, peliculaID)
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
    public boolean removeUsuFK(Long perfilID) {
        boolean resultado;
        int res = entityManager.createNativeQuery("DELETE FROM perfil_usuario WHERE perfil_id = ?")
        .setParameter(1, perfilID)
        .executeUpdate();
        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }
}
