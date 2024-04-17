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
@Table(name = "temporada")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Temporada extends Base{
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "capitulos")
    private int capitulos;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_serie")
    private Serie serie;
}
