package com.disney.service.impl;

import java.util.List;
import java.util.Optional;

import com.disney.dto.CharacterBasicDTO;
import com.disney.dto.CharacterDetailledDTO;
import com.disney.dto.CharacterFiltersDTO;
import com.disney.entity.CharacterEntity;
import com.disney.exception.ParamNotFound;
import com.disney.mapper.CharacterMapper;
import com.disney.repository.CharacterRepository;
import com.disney.repository.specifications.CharacterSpecification;
import com.disney.service.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired 
    private CharacterSpecification characterSpecification;
    
    public CharacterDetailledDTO save (CharacterDetailledDTO dto) {
        CharacterEntity character = characterMapper.characterDTO2Entity(dto);
        CharacterEntity new_character = characterRepository.save(character);
        CharacterDetailledDTO result = characterMapper.characterEntity2DTO(new_character);
        return result;
    }

    public List<CharacterBasicDTO> getallPersonajes() {
        List<CharacterEntity> characters = characterRepository.findAll();
        List<CharacterBasicDTO> result = characterMapper.characterEntityList2BasicDTOList(characters);
        return result;
    }

    public CharacterDetailledDTO getById (Long id) {
        Optional <CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("This characerId is not present");
        }
        CharacterDetailledDTO character = characterMapper.characterEntity2DTO(entity.get());
        //AGREGAR LOAD PAISES = TRUE
        return character;
    }

    public CharacterDetailledDTO update(Long id, CharacterDetailledDTO dto) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("This characerId is not present" + id);
        }
        characterMapper.update(entity.get(), dto);
        characterRepository.save(entity.get());
        CharacterDetailledDTO result = characterMapper.characterEntity2DTO(entity.get());// CONSULTAR COMO AGREGAR EL LOADPELICULAS FALSE
        return result;
    }

    public void delete (Long id) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("This characerId is not present");
        }
        characterRepository.deleteById(id);
    }

    @Override
    public List<CharacterBasicDTO> getByFilters(String name, Long age, List<Long> movies, String order) {
        CharacterFiltersDTO filters = new CharacterFiltersDTO(name, age, movies, order);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filters));
        List<CharacterBasicDTO> dtos = characterMapper.characterEntityList2BasicDTOList(entities);
        return dtos;
    }
    
}
