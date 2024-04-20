package com.api.tellix.entities;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.envers.Audited;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Perfil extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "imagen")
    private Blob imagen;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "watchlist_serie",
        joinColumns = @JoinColumn(name = "perfil_id"),
        inverseJoinColumns = @JoinColumn(name = "serie_id")
        )
    private List<Serie> series = new ArrayList<Serie>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "watchlist_pelicula",
        joinColumns = @JoinColumn(name = "perfil_id"),
        inverseJoinColumns = @JoinColumn(name = "pelicula_id")
        )
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();
}
