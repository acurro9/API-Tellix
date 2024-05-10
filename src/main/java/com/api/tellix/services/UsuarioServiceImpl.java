package com.api.tellix.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.api.tellix.entities.Usuario;
import com.api.tellix.repositories.BaseRepository;
import com.api.tellix.repositories.UsuarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
    public boolean addPerfil(Long usuID, Long perfilID)throws Exception{
        try{
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
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean removePerfil(Long perfilID)throws Exception{
        try{
            boolean resultado;
            int res = entityManager.createNativeQuery("DELETE FROM perfil_usuario where perfil_id=?")
            .setParameter(1, perfilID)
            .executeUpdate();
            if(res == 1){
                resultado = true;
            } else{
                resultado = false;
            }
            return resultado;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Long crearPerfil(String nombre)throws Exception{
        try{
        entityManager.createNativeQuery("INSERT INTO perfil (`nombre`) VALUES (?);")
        .setParameter(1, nombre)
        .executeUpdate();
        
        Query selectQuery = entityManager.createNativeQuery("SELECT id FROM perfil WHERE id = (SELECT LAST_INSERT_ID());");
        selectQuery.getResultList();

        Long insertedId = (Long) selectQuery.getSingleResult(); 

        return insertedId;
    }catch (Exception e) {
        throw new Exception(e.getMessage());
    }
    }

    @Override
    @Transactional
    public boolean bloqUsu(Long id, boolean bloq)throws Exception{
        try{
        boolean resultado;
        int res = entityManager.createNativeQuery("UPDATE usuario SET bloqueado = ? WHERE id = ?;")
        .setParameter(1, bloq)
        .setParameter(2, id)
        .executeUpdate();

        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }catch (Exception e) {
        throw new Exception(e.getMessage());
    }
    }

    @Override
    @Transactional
    public boolean suscripcion(Long id, boolean bloq)throws Exception{
        try{
        boolean resultado;
        int res = entityManager.createNativeQuery("UPDATE usuario SET suscripcion = ? WHERE id = ?;")
        .setParameter(1, bloq)
        .setParameter(2, id)
        .executeUpdate();

        if(res == 1){
            resultado = true;
        } else{
            resultado = false;
        }
        return resultado;
    }catch (Exception e) {
        throw new Exception(e.getMessage());
    }
    }

    @Override
    @Transactional
    public Usuario obtainUsu(String mail) throws Exception{
        try{
            Usuario usuario = usuarioRepository.obtainUsu(mail);
            return usuario;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean checkBloq(String mail) throws Exception{
        try{
            boolean resQuery = usuarioRepository.checkBloq(mail);
            return resQuery;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean checkSus(String mail) throws Exception{
        try{
            boolean resQuery = usuarioRepository.checkSus(mail);
            return resQuery;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public String encryptPassword(String password) throws Exception{
        try{
            return BCrypt.hashpw(password, BCrypt.gensalt());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean verifyPassword(String originalPassword, String hashPassword) throws Exception{
        try{
            return BCrypt.checkpw(originalPassword, hashPassword);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    };
}

