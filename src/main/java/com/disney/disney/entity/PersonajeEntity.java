package com.disney.disney.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    private String imagen;

    private String nombre;

    private Long edad;

    private Float peso;

    private String historia;

    @ManyToMany(mappedBy = "personajes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PeliculaEntity> peliculas = new ArrayList<>();
}
