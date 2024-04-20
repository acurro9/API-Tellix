package com.api.tellix.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Perfil;
import java.util.List;


@Repository
public interface PerfilRepository extends BaseRepository <Perfil, Long>{
    @Query(
        value = "SELECT * FROM perfil WHERE id = %:id%;",
        nativeQuery = true
    )
    List<Perfil> searchById(Long id);

    @Query(
        value = "select perfil.* from perfil where id in (select perfil_id from perfil_usuario where usuario_id = %:filtro%)",
        nativeQuery = true
    )
    List<Perfil> searchPerfil(Long filtro);
}
