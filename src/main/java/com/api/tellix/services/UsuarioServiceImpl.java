package com.api.tellix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tellix.entities.Usuario;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Long> implements UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(BaseRepository<Usuario, Long> baseRepository){
        super(baseRepository);
    }

    public boolean existsByCorreo(String correo) throws Exception{
        try {
            boolean usuario = usuarioRepository.existsByCorreo(correo);
            return usuario;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
