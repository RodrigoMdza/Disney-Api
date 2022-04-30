package com.disney.mapper;

import java.util.ArrayList;
import java.util.List;

import com.disney.dto.CharacterDetailledDTO;
import com.disney.dto.MovieBasicDTO;
import com.disney.dto.MovieDetailedDTO;
import com.disney.entity.CharacterEntity;
import com.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    @Autowired
    private CharacterMapper characterMapper;

    public MovieEntity movieDTO2Entity(MovieDetailedDTO dto) {
        MovieEntity movie = new MovieEntity();
        movie.setImage(dto.getImage());
        movie.setTitle(dto.getTitle());
        movie.setCreationDate(dto.getCreationDate());
        movie.setRating(dto.getRating());
        movie.setGenderId(dto.getGenderId());
        movie.setCharacters(dto.getCharacters());
        return movie;
    }

    public MovieDetailedDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters) {
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

    public List<MovieDetailedDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters) {
        List<MovieDetailedDTO> dtos = new ArrayList<>();
        for (MovieEntity entity : entities) {
            dtos.add(this.movieEntity2DTO(entity, loadCharacters));
        }
        return dtos;
    }

    public List<MovieBasicDTO> movieEntityList2BasicDTOList(List<MovieEntity> entities) {
        List<MovieBasicDTO> dtos = new ArrayList<>();
        MovieBasicDTO basicDTO;
        for (MovieEntity entity : entities) {
            basicDTO = new MovieBasicDTO();
            basicDTO.setImage(entity.getImage());
            basicDTO.setTitle(entity.getTitle());
            basicDTO.setCreationDate(entity.getCreationDate());
            dtos.add(basicDTO);
             }
        return dtos;
        }

        public List<MovieEntity> movieDetailedDTOList2EntityList(List<MovieDetailedDTO> dtos) {
            List<MovieEntity> entities = new ArrayList<>();
            for (MovieDetailedDTO dto : dtos) {
                entities.add(this.movieDTO2Entity(dto));
            }
            return entities;
        }

        public void update (MovieEntity entity, MovieDetailedDTO dto) {
            entity.setImage(dto.getImage());
            entity.setTitle(dto.getTitle());
            entity.setCreationDate(dto.getCreationDate());
            entity.setRating(dto.getRating());
            entity.setGenderId(dto.getGenderId());
        }

}
