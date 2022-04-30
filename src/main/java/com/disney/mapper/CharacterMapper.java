package com.disney.mapper;

import java.util.ArrayList;
import java.util.List;

import com.disney.dto.MovieDetailedDTO;
import com.disney.entity.MovieEntity;
import com.disney.dto.CharacterBasicDTO;
import com.disney.dto.CharacterDetailledDTO;
import com.disney.entity.CharacterEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

    @Autowired
    private MovieMapper movieMapper;
    
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
    
    public CharacterDetailledDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies) {
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
    
    public List<CharacterDetailledDTO> characterEntityList2DTOList(List<CharacterEntity> entities, boolean loadMovies) {
        List<CharacterDetailledDTO> dtos = new ArrayList<>();
        for (CharacterEntity entity : entities) {
            dtos.add(this.characterEntity2DTO(entity, loadMovies));
        }
        return dtos;
    }
    
    public List<CharacterBasicDTO> characterEntityList2BasicDTOList(List<CharacterEntity> entities) {
        List<CharacterBasicDTO> dtos = new ArrayList<>();
        CharacterBasicDTO basicDTO;
        for (CharacterEntity entity : entities) {
            basicDTO = new CharacterBasicDTO();
            basicDTO.setImage(entity.getImage());
            basicDTO.setName(entity.getName());
            dtos.add(basicDTO);
        }
        return dtos;
    }
    
    public List<CharacterEntity> characterDetailedDTOList2EntityList(List<CharacterDetailledDTO> dtos) {
        List<CharacterEntity> entities = new ArrayList<>();
        for (CharacterDetailledDTO dto : dtos) {
            entities.add(this.characterDTO2Entity(dto));
        }
        return entities;
    }

    public void update (CharacterEntity entity, CharacterDetailledDTO dto) {
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
    }

}