package com.api.tellix.entities;

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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.envers.Audited;

@Entity
@Table(name = "pelicula")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Pelicula extends Base{
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "imagen")
    private String imagen;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "pelicula_categoria",
        joinColumns = @JoinColumn (name = "pelicula_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
        )
    private List<Categoria> categorias = new ArrayList<Categoria>();
}
