package com.disney.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GenderDTO {
    private Long id;
    @NotNull(message = "Please insert a valid name")
    private String name;
    private String image;

}
