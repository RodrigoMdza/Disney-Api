package com.disney.service.impl;

import java.util.List;
import java.util.Optional;

import com.disney.dto.CharacterBasicDTO;
import com.disney.dto.CharacterDetailledDTO;
import com.disney.dto.CharacterFiltersDTO;
import com.disney.entity.CharacterEntity;
import com.disney.exception.ErrorsEnum;
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
        CharacterDetailledDTO result = characterMapper.characterEntity2DTO(new_character, true);
        return result;
    }

    @Override
    public List<CharacterBasicDTO> getByFilters(String name, Long age, List<Long> moviesId, String order) {
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, moviesId, order);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
        List<CharacterBasicDTO> dtos = characterMapper.characterEntityList2BasicDTOList(entities);
        return dtos;
    }

    public CharacterDetailledDTO getById (Long id) {
        Optional <CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        CharacterDetailledDTO character = characterMapper.characterEntity2DTO(entity.get(), true);
        return character;
    }

    public CharacterDetailledDTO update(Long id, CharacterDetailledDTO dto) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        characterMapper.update(entity.get(), dto);
        characterRepository.save(entity.get());
        CharacterDetailledDTO result = characterMapper.characterEntity2DTO(entity.get(), true);// CONSULTAR COMO AGREGAR EL LOADPELICULAS FALSE
        return result;
    }

    public void delete (Long id) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound(ErrorsEnum.IDCHARACTERNOTFOUND.getMessage());
        }
        characterRepository.delete(entity.get());
    }
    
}
