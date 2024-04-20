package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.entities.Perfil;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.PeliculaRepository;
import com.api.tellix.repositories.PerfilRepository;

import jakarta.transaction.Transactional;

@Service
public class PerfilServiceImpl extends BaseServiceImpl<Perfil, Long> implements PerfilService{
    @Autowired
    private PerfilRepository perfilRepository;

    public PerfilServiceImpl(BaseRepository<Perfil, Long> baseRepository) {
        super(baseRepository);
    }

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

    // @Override
    // @Transactional
    // public Perfil addFilm(Long id, Perfil perfil) throws Exception {
    //     try{
            
    //         return 
    //     } catch (Exception e){
    //         throw new Exception(e.getMessage());
    //     }
    // }
}
