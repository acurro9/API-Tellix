package com.api.tellix.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "serie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Serie extends Contenido{

    @Column(name = "temporadas")
    private int temporadas;
    
}
