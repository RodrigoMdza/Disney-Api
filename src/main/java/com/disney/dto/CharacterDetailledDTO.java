package com.disney.dto;

import java.util.List;

import com.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDetailledDTO {
    
    private Long id;
    private String image;
    private String name;
    private Long age;
    private float weight;
    private String history;
    private List<MovieEntity> movies;

}
