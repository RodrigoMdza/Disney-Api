package com.disney.service;

import java.util.List;

import com.disney.dto.MovieBasicDTO;
import com.disney.dto.MovieDetailedDTO;

public interface MovieService {
    
    MovieDetailedDTO save(MovieDetailedDTO dto);
    MovieDetailedDTO getById(Long id);
    List<MovieBasicDTO> getallPeliculas();
    MovieDetailedDTO addCharacter(Long id, Long characterId);
    MovieDetailedDTO deleteCharacter(Long id, Long characterId);
    MovieDetailedDTO update(Long id, MovieDetailedDTO dto);
    void delete (Long id);

}
