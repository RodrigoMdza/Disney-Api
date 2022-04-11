package com.disney.disney.service.impl;

import java.util.List;

import com.disney.disney.dto.GeneroDTO;
import com.disney.disney.entity.GeneroEntity;
import com.disney.disney.mapper.GeneroMapper;
import com.disney.disney.repository.GeneroRepository;
import com.disney.disney.service.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements GeneroService{

    @Autowired
    private GeneroMapper generoMapper;
    @Autowired
    private GeneroRepository generoRepository;

    public GeneroDTO save (GeneroDTO dto) {
        GeneroEntity genero = generoMapper.generoDTO2Entity(dto);
        GeneroEntity generoGuardado = generoRepository.save(genero);
        GeneroDTO result = generoMapper.generoEntity2DTO(generoGuardado);
        return result;
    }

    public List<GeneroDTO> getallGeneros() {
        List<GeneroEntity> generos = generoRepository.findAll();
        List<GeneroDTO> result = generoMapper.generoEntityList2DTOList(generos);
        return result;
    }
 
}
