package com.disney.mapper;

import java.util.ArrayList;
import java.util.List;

import com.disney.repository.MovieRepository;
import com.disney.dto.CharacterBasicDTO;
import com.disney.dto.CharacterDetailledDTO;
import com.disney.entity.CharacterEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    @Autowired
    MovieRepository movieReository;
    
    public CharacterEntity characterDTO2Entity(CharacterDetailledDTO dto) {
        CharacterEntity character = new CharacterEntity();
        character.setImage(dto.getImage());
        character.setName(dto.getName());
        character.setAge(dto.getAge());
        character.setWeight(dto.getWeight());
        character.setHistory(dto.getHistory());
        character.setMovies(dto.getMovies());
        return character;
    }
    
    public CharacterDetailledDTO characterEntity2DTO(CharacterEntity entity) {
        CharacterDetailledDTO dto = new CharacterDetailledDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        dto.setMovies(entity.getMovies());
        return dto;
    }

    public List<CharacterDetailledDTO> characterEntityList2DTOList(List<CharacterEntity> entities) {
        List<CharacterDetailledDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities) {
            dtos.add(characterEntity2DTO(entity));
        }
        return dtos;
    }

    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> entities) {
        List<CharacterBasicDTO> dtos = new ArrayList<>();
        CharacterBasicDTO basicDTO;
        for (CharacterEntity entity : entities) {
            basicDTO = new CharacterBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImage(entity.getImage());
            basicDTO.setName(entity.getName());
            dtos.add(basicDTO);
        }
        return dtos;
    }

    public void update (CharacterEntity entity, CharacterDetailledDTO dto) {
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
    }

}