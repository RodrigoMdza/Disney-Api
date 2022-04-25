package com.disney.dto;

import java.util.List;

public class CharacterFiltersDTO {
    
        private String name;
        private Long age;
        private List<Long> movies;
        private String order;
    
        public CharacterFiltersDTO(String name, Long age, List<Long> movies, String order) {
            this.name = name;
            this.age = age;
            this.movies = movies;
            this.order = order;
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
        public List<Long> getMovies() {
            return movies;
        }
        public void setMovies(List<Long> movies) {
            this.movies = movies;
        }
        public String getOrder() {
            return order;
        }
        public void setOrder(String order) {
            this.order = order;
        }
    
        public boolean isASC() {return order.compareToIgnoreCase("ASC") == 0;}
        public boolean isDESC() {return order.compareToIgnoreCase("DESC") == 0;}
    }

