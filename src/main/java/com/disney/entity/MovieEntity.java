package com.disney.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE movie SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class MovieEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String title;

    @Column(name="creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    @Range(min = 0, max = 5)
    private int rating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", insertable = false, updatable = false)
    private GenderEntity gender;

    @NotNull
    @Column(name = "gender_id", nullable = false)
    private Long genderId;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_character",
               joinColumns = @JoinColumn(name = "movie_id"),
               inverseJoinColumns = @JoinColumn(name = "character_id"))
    private List<CharacterEntity> characters = new ArrayList<>();

    private boolean deleted=Boolean.FALSE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieEntity movie = (MovieEntity) o;

        if (Double.compare(movie.rating, rating) != 0) return false;
        if (!Objects.equals(id, movie.id)) return false;
        return Objects.equals(characters, movie.characters);
    }

}
