package com.api.tellix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Perfil;
import com.api.tellix.entities.Usuario;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository){
        super(baseRepository);
    }

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

}
