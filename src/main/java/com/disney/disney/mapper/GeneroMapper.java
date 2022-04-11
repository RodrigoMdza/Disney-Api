package com.disney.disney.mapper;

import java.util.ArrayList;
import java.util.List;

import com.disney.disney.dto.GeneroDTO;
import com.disney.disney.entity.GeneroEntity;

import org.springframework.stereotype.Component;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO dto) {
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;
    }
    
    public GeneroDTO generoEntity2DTO(GeneroEntity entity) {
        GeneroDTO dto = new GeneroDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setNombre(entity.getNombre());
        return dto;
    }

    public List<GeneroDTO> generoEntityList2DTOList(List<GeneroEntity> entities) {
        List<GeneroDTO> dtos = new ArrayList<>();
        for (GeneroEntity entity : entities) {
            dtos.add(this.generoEntity2DTO(entity));
        }
        return dtos;
    }
    
}