package com.disney.disney.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "genero.id", insertable = false, updatable = false)
    private GeneroEntity genero;
    // CONSULTAR SI AL CREAR LA PELICULA TAMBIEN SE CREA UNA NUEVA TABLA EN GENERO
    // Y CON QUE NOMBRE. AL EXISTIR YA EL OBJETO DE ACTUALIZA O DUPLICA.

    @Column(name = "genero.id", nullable = false)
    private Long generoId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    // CONSULTAR PORQUE SE PONEN LAS LLAVES Y SI HACE EL PERSIST CUANDO NO
    // HAY ENTIDAD GUARDADA Y MERGE CUANDO SI HAY PARA NO DUPLICARLO.
    @JoinTable(name = "pelicula_personaje",
               joinColumns = @JoinColumn(name = "pelicula_id"),
               inverseJoinColumns = @JoinColumn(name = "personaje_id") )
     private List<PersonajeEntity> personajes = new ArrayList<>();

}
