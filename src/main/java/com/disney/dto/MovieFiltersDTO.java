package com.disney.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieFiltersDTO {
    
    private String name;
    private Long gender;
    String order;

    public MovieFiltersDTO(String name, Long gender, String order) {
        this.name = name;
        this.gender = gender;
        this.order = order;
    }

    public boolean isASC(){ return this.order.compareToIgnoreCase("ASC") == 0;}
    public boolean isDESC(){ return this.order.compareToIgnoreCase("DESC") == 0;}

}


