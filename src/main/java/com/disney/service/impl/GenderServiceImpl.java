package com.disney.service.impl;

import com.disney.dto.GenderDTO;
import com.disney.entity.GenderEntity;
import com.disney.mapper.GenderMapper;
import com.disney.repository.GenderRepository;
import com.disney.service.GenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService{

    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;

    public GenderDTO save (GenderDTO dto) {
        GenderEntity gender = genderMapper.genderDTO2Entity(dto);
        GenderEntity new_gender = genderRepository.save(gender);
        GenderDTO result = genderMapper.genderEntity2DTO(new_gender);
        return result;
    }

}
