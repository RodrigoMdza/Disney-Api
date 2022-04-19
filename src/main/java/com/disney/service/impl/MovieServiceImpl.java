package com.disney.service.impl;

import java.util.List;
import java.util.Optional;

import com.disney.dto.MovieBasicDTO;
import com.disney.dto.MovieDetailedDTO;
import com.disney.entity.MovieEntity;
import com.disney.exception.ParamNotFound;
import com.disney.entity.CharacterEntity;
import com.disney.mapper.MovieMapper;
import com.disney.repository.MovieRepository;
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
    
    public MovieDetailedDTO save (MovieDetailedDTO dto) {
        MovieEntity movie = movieMapper.movieDTO2Entity(dto);
        MovieEntity new_movie = movieRepository.save(movie);
        MovieDetailedDTO result = movieMapper.movieEntity2DTO(new_movie);
        return result;
    }

    public MovieDetailedDTO getById (Long id) {
        Optional <MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("This movieId is not present");
        }
        MovieDetailedDTO movie = movieMapper.movieEntity2DTO(entity.get());
        //AGREGAR LOAD PAISES = TRUE
        return movie;
    }

    public List<MovieBasicDTO> getallPeliculas() {
        List<MovieEntity> movies = movieRepository.findAll();
        List<MovieBasicDTO> result = movieMapper.movieEntityList2BasicDTOList(movies);
        return result;
    }

    public void addCharacter (Long id, Long characterId) {
        MovieEntity movie = movieRepository.getById(id);
        CharacterEntity character =characterRepository.getById(characterId);
        movie.getCharacters().add(character);
        movieRepository.save(movie);
    }

    public void deleteCharacter (Long id, Long characterId) {
        MovieEntity movie = movieRepository.getById(id);
        CharacterEntity character = characterRepository.getById(characterId);
        List<CharacterEntity> characters = movie.getCharacters();
        characters.remove(character);
        movieRepository.save(movie);
    }

    public MovieDetailedDTO update(Long id, MovieDetailedDTO dto) {
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("This movieId is not present");
        }
        movieMapper.update(entity.get(), dto);
        movieRepository.save(entity.get());
        MovieDetailedDTO result = movieMapper.movieEntity2DTO(entity.get());// CONSULTAR COMO AGREGAR EL LOADPELICULAS FALSE
        return result;
    }

    public void delete (Long id) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("This movieId is not present");
        }
        movieRepository.deleteById(id);
    }

}
