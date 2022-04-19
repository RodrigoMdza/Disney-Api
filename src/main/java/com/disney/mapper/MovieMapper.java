package com.disney.mapper;

import java.util.ArrayList;
import java.util.List;

import com.disney.dto.MovieBasicDTO;
import com.disney.dto.MovieDetailedDTO;
import com.disney.entity.MovieEntity;
import com.disney.repository.GenderRepository;
import com.disney.repository.CharacterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    GenderRepository genderRepository;
    @Autowired
    CharacterRepository characterRepository;
    
    public MovieEntity movieDTO2Entity(MovieDetailedDTO dto) {
        MovieEntity movie = new MovieEntity();
        movie.setImage(dto.getImage());
        movie.setTitle(dto.getTitle());
        movie.setCreationDate(dto.getCreationDate());
        movie.setRating(dto.getRating());
        movie.setGenderId(dto.getGenderId());;
        movie.setCharacters(dto.getCharacters());
        return movie;
    }
    
    public MovieDetailedDTO movieEntity2DTO(MovieEntity entity) {
        MovieDetailedDTO dto = new MovieDetailedDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setTitle(entity.getTitle());
        dto.setCreationDate(entity.getCreationDate());
        dto.setRating(entity.getRating());
        dto.setGenderId(entity.getGenderId());
        dto.setCharacters(entity.getCharacters());
        return dto;
    }

    public List<MovieDetailedDTO> movieEntityList2DTOList(List<MovieEntity> entities) {
        List<MovieDetailedDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities) {
            dtos.add(movieEntity2DTO(entity));
        }
        return dtos;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<MovieEntity> entities) {
        List<MovieBasicDTO> dtos = new ArrayList<>();
        MovieBasicDTO basicDTO;
        for (MovieEntity entity : entities) {
            basicDTO = new MovieBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImage(entity.getImage());
            basicDTO.setTitle(entity.getTitle());
            basicDTO.setCreationDate(entity.getCreationDate());
            dtos.add(basicDTO);
             }
        return dtos;
        }

        public void update (MovieEntity entity, MovieDetailedDTO dto) {
            entity.setImage(dto.getImage());
            entity.setTitle(dto.getTitle());
            entity.setCreationDate(dto.getCreationDate());
            entity.setRating(dto.getRating());
            entity.setGenderId(dto.getGenderId());
            entity.setCharacters(dto.getCharacters());
        }

}
