package com.disney.dto;

import java.time.LocalDate;
import java.util.List;

import com.disney. entity.CharacterEntity;

public class MovieDetailedDTO {
    
    private Long id;
    private String image;
    private String title;
    private LocalDate creationDate;
    private int rating;
    private Long genderId;
    private List <CharacterEntity> characters;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public Long getGenderId() {
        return genderId;
    }
    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }
    public List<CharacterEntity> getCharacters() {
        return characters;
    }
    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }
    
}
