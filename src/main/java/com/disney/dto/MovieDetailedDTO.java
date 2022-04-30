package com.disney.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.disney. entity.CharacterEntity;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDetailedDTO {
    
    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    @Range(min = 0, max = 5, message = "must be a number between 1 and 5")
    private int rating;
    @NotNull(message = "Please insert a valid gender")
    private Long genderId;
    private List <CharacterEntity> characters;

}
