package com.disney.controller;

import java.util.List;

import com.disney.dto.CharacterBasicDTO;
import com.disney.dto.CharacterDetailledDTO;
import com.disney.service.CharacterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("characters")
public class CharacterController {
    
    @Autowired
    private CharacterService characterService;

    @PostMapping
    public ResponseEntity<CharacterDetailledDTO> save (@RequestBody CharacterDetailledDTO character) {
        CharacterDetailledDTO result = characterService.save(character);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CharacterBasicDTO>> getall() {
        List<CharacterBasicDTO> characters = characterService.getallPersonajes();
        return ResponseEntity.ok().body(characters);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDetailledDTO>getById(@PathVariable Long id) {
        CharacterDetailledDTO character = characterService.getById(id);
        return ResponseEntity.ok(character);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDetailledDTO> update (@PathVariable Long id, @RequestBody CharacterDetailledDTO gender) {
        CharacterDetailledDTO result = characterService.update(id, gender);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        characterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /*
    @GetMapping
    public ResponseEntity<List<CharacterDetailledDTO>> getByFilters (
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Long age,
        @RequestParam(required = false) List<Long> movies,
        @RequestParam(required = false, defaultValue = "ASC") String order
     ) {
        List<CharacterDetailledDTO> characters = characterService.getByFilters(name, age, movies, order);
        return ResponseEntity.ok(characters);
    }
    */
}
