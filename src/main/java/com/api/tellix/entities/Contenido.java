package com.api.tellix.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.envers.Audited;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public abstract class Contenido extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "contenido_categoria",
        joinColumns = @ JoinColumn (name = "contenido_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
        )
    private List<Categoria> categorias = new ArrayList<Categoria>();
}