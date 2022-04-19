package com.disney.service;

import java.util.List;

import com.disney.dto.CharacterBasicDTO;
import com.disney.dto.CharacterDetailledDTO;

public interface CharacterService {
    
    CharacterDetailledDTO save(CharacterDetailledDTO dto);
    List<CharacterBasicDTO> getallPersonajes();
    CharacterDetailledDTO getById(Long id);
    //List<CharacterDetailledDTO> getByFilters(String name,Long age, List<Long> movies,String order);
    CharacterDetailledDTO update(Long id, CharacterDetailledDTO dto);
    void delete (Long id);
    
}
