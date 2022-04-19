package com.disney.dto;

import java.util.List;

import com.disney.entity.MovieEntity;

public class CharacterDetailledDTO {
    
    private Long id;
    private String image;
    private String name;
    private Long age;
    private float weight;
    private String history;
    private List<MovieEntity> movies;

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getAge() {
        return age;
    }
    public void setAge(Long age) {
        this.age = age;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public String getHistory() {
        return history;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    public List<MovieEntity> getMovies() {
        return movies;
    }
    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

}
