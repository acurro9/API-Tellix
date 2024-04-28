package com.api.tellix.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository <Usuario, Long>{
    
    boolean existsByCorreo(String filtro);

    @Query(
        value = "select perfil_id from perfil_usuario where usuario_id = :filtro",
        nativeQuery = true
    )
    List<Long> searchByUsuID(Long filtro);

    @Query(
        value = "select * from usuario where correo like :correo",
        nativeQuery = true
    )
    Usuario obtainUsu(String correo);

    @Query(
        value = "select bloqueado from usuario where correo like :correo",
        nativeQuery = true
    )
    boolean checkBloq(String correo);

    
}
