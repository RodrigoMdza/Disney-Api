package com.disney.disney.service;

import java.util.List;

import com.disney.disney.dto.GeneroDTO;

public interface GeneroService {

    GeneroDTO save(GeneroDTO dto);
    List<GeneroDTO> getallGeneros();
    
}
