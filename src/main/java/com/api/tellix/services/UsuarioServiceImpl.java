package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.tellix.entities.Usuario;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.UsuarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository){
        super(baseRepository);
    }

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    @Transactional
    public boolean existsByCorreo(String filtro) throws Exception{
        try {
            boolean usuario = usuarioRepository.existsByCorreo(filtro);
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Long> searchByUsuID(Long filtro) throws Exception{
        try{
            List<Long> perfilIDs = usuarioRepository.searchByUsuID(filtro);
            return perfilIDs;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean addPerfil(Long usuID, Long perfilID) {
        boolean resultado;
        int res = entityManager.createNativeQuery("INSERT INTO perfil_usuario (usuario_id, perfil_id) VALUES (?, ?)")
        .setParameter(1, usuID)
        .setParameter(2, perfilID)
        .executeUpdate();
        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }
}

