package com.api.tellix.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.tellix.entities.Pelicula;
import com.api.tellix.entities.Perfil;
import java.util.List;


@Repository
public interface PerfilRepository extends BaseRepository <Perfil, Long>{
    @Query(
        value = "SELECT * FROM perfil WHERE id = :id;",
        nativeQuery = true
    )
    List<Perfil> searchById(Long id);

    @Query(
        value = "select perfil.* from perfil where id in (select perfil_id from perfil_usuario where usuario_id = :filtro)",
        nativeQuery = true
    )
    List<Perfil> searchPerfil(Long filtro);
    @Query(
        value = "INSERT INTO watchlist_pelicula (perfil_id, pelicula_id) VALUES (:perfilID, :peliculaID)",
        nativeQuery = true
    )
    boolean addPelicula(Long perfilID, Long peliculaID);

    @Query(
        value = "select * from pelicula where id in (select pelicula_id from watchlist_pelicula where perfil_id = :perfilID)",
        nativeQuery = true
    )
    List<Pelicula> searchFilms(Long perfilID);

    @Query(
        value = "select * from serie where id in (select serie_id from watchlist_serie where perfil_id = :perfilID)",
        nativeQuery = true
    )
    List<Pelicula> searchSeries(Long perfilID);

}
