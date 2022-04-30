package com.disney.service.impl;

import java.util.List;
import java.util.Optional;

import com.disney.dto.MovieBasicDTO;
import com.disney.dto.MovieDetailedDTO;
import com.disney.dto.MovieFiltersDTO;
import com.disney.entity.MovieEntity;
import com.disney.exception.ErrorsEnum;
import com.disney.exception.ParamNotFound;
import com.disney.entity.CharacterEntity;
import com.disney.mapper.MovieMapper;
import com.disney.repository.MovieRepository;
import com.disney.repository.specifications.MovieSpecification;
import com.disney.repository.CharacterRepository;
import com.disney.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{
    
    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private MovieSpecification movieSpecification;
    
    public MovieDetailedDTO save (MovieDetailedDTO dto) {
        MovieEntity movie = movieMapper.movieDTO2Entity(dto);
        MovieEntity new_movie = movieRepository.save(movie);
        MovieDetailedDTO result = movieMapper.movieEntity2DTO(new_movie, true);
        return result;
    }

    @Override
    public List<MovieBasicDTO> getByFilters(String name, Long gender, String order) {
        MovieFiltersDTO filtersDTO = new MovieFiltersDTO(name, gender, order);
        List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDTO));
        List<MovieBasicDTO> basicDTOS = movieMapper.movieEntityList2BasicDTOList(entities);
        return basicDTOS;
    }

    public MovieDetailedDTO getById (Long id) {
        Optional <MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        MovieDetailedDTO movie = movieMapper.movieEntity2DTO(entity.get(), true);
        //AGREGAR LOAD PAISES = TRUE
        return movie;
    }

    public MovieDetailedDTO addCharacter (Long id, Long characterId) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        MovieEntity movie = movieOptional.get();
        Optional<CharacterEntity> characterOptional = characterRepository.findById(characterId);
        if (!characterOptional.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        CharacterEntity character = characterOptional.get();
        movie.getCharacters().add(character);
        movieRepository.save(movie);
        MovieDetailedDTO result = movieMapper.movieEntity2DTO(movie, true);
        return result;
    }

    public MovieDetailedDTO deleteCharacter (Long id, Long characterId) {
        Optional<MovieEntity> movieOptional = movieRepository.findById(id);
        if(!movieOptional.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        MovieEntity movie = movieOptional.get();
        Optional<CharacterEntity> characterOptional = characterRepository.findById(characterId);
        if (!characterOptional.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        CharacterEntity character = characterOptional.get();
        movie.getCharacters().remove(character);
        movieRepository.save(movie);
        MovieDetailedDTO movie2 = movieMapper.movieEntity2DTO(movie, true);
        return movie2;
    }

    public MovieDetailedDTO update(Long id, MovieDetailedDTO dto) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        movieMapper.update(entity.get(), dto);
        movieRepository.save(entity.get());
        MovieDetailedDTO result = movieMapper.movieEntity2DTO(entity.get(), true);
        return result;
    }

    public void delete (Long id) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDMOVIENOTFOUND.getMessage());
        }
        movieRepository.deleteById(id);
    }

}
