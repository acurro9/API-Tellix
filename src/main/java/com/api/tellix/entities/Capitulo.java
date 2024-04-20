package com.api.tellix.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "capitulo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Capitulo  extends Base{
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_temporada")
    private Temporada temporada;
}