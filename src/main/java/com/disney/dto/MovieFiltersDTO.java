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
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Long getGender() {
        return gender;
    }


    public void setGender(Long gender) {
        this.gender = gender;
    }


    public String getOrder() {
        return order;
    }


    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isASC(){ return this.order.compareToIgnoreCase("ASC") == 0;}
    public boolean isDESC(){ return this.order.compareToIgnoreCase("DESC") == 0;}
    
}


