package com.disney.disney.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="pelicula")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String imagen;

    private String titulo;

    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate fechaCreacion;

    private int calificacion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "genero.id", insertable = false, updatable = false)
    private GeneroEntity genero;

    @Column(name = "genero.id", nullable = false)
    private Long generoId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "pelicula_personaje",
               joinColumns = @JoinColumn(name = "pelicula_id"),
               inverseJoinColumns = @JoinColumn(name = "personaje_id") )
     private List<PersonajeEntity> personajes = new ArrayList<>();

}
