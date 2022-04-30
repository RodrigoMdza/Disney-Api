package com.disney.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterFiltersDTO {
    
        private String name;
        private Long age;
        private List<Long> moviesId;
        private String order;
        
        public CharacterFiltersDTO(String name, Long age, List<Long> moviesId, String order) {
            this.name = name;
            this.age = age;
            this.moviesId = moviesId;
            this.order = order;
        }

        public boolean isASC(){ return this.order.compareToIgnoreCase("ASC") == 0;}
        public boolean isDESC(){ return this.order.compareToIgnoreCase("DESC") == 0;}

    }

