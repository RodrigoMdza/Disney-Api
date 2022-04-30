package com.disney.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="characters")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE character SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CharacterEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String name;

    private Long age;

    private Float weight;

    private String history;

    @ManyToMany(mappedBy = "characters", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MovieEntity> movies = new ArrayList<>();

    private boolean deleted=Boolean.FALSE;

}
