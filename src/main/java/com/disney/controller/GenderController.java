package com.disney.controller;

import javax.validation.Valid;

import com.disney.dto.GenderDTO;
import com.disney.service.GenderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @PostMapping
    public ResponseEntity<GenderDTO> save (@Valid @RequestBody GenderDTO gender) {
        GenderDTO new_gender = genderService.save(gender);
        return ResponseEntity.status(HttpStatus.CREATED).body(new_gender);
    }

}