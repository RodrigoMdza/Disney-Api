package com.disney.mapper;

import com.disney.dto.GenderDTO;
import com.disney.entity.GenderEntity;

import org.springframework.stereotype.Component;

@Component
public class GenderMapper {

    public GenderEntity genderDTO2Entity(GenderDTO dto) {
        GenderEntity gender = new GenderEntity();
        gender.setImage(dto.getImage());
        gender.setName(dto.getName());
        return gender;
    }
    
    public GenderDTO genderEntity2DTO(GenderEntity entity) {
        GenderDTO dto = new GenderDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }
    
}