package com.disney.service;

import java.util.List;

import com.disney.dto.CharacterBasicDTO;
import com.disney.dto.CharacterDetailledDTO;

public interface CharacterService {
    
    CharacterDetailledDTO save(CharacterDetailledDTO dto);
    CharacterDetailledDTO getById(Long id);
    List<CharacterBasicDTO> getByFilters(String name,Long age, List<Long> moviesId,String order);
    CharacterDetailledDTO update(Long id, CharacterDetailledDTO dto);
    void delete (Long id);
    
}
