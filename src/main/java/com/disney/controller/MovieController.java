package com.disney.controller;

import java.util.List;

import javax.validation.Valid;

import com.disney.dto.MovieBasicDTO;
import com.disney.dto.MovieDetailedDTO;
import com.disney.service.MovieService;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDetailedDTO> save (@Valid @RequestBody MovieDetailedDTO movie) throws Exception {
        MovieDetailedDTO new_movie = movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(new_movie);
    }

    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getDetailsByFilters(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Long gender,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<MovieBasicDTO> movies = movieService.getByFilters(title, gender, order);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailedDTO>getById(@PathVariable Long id) {
        MovieDetailedDTO movie = movieService.getById(id);
        return ResponseEntity.ok(movie);
    }
    
    @PostMapping("/{id}/characters/{characterId}")
    public ResponseEntity<MovieDetailedDTO> addCharacter (@PathVariable Long id, @PathVariable Long characterId) {
        MovieDetailedDTO movie = movieService.addCharacter(id, characterId);
        return ResponseEntity.ok().body(movie);
    }

    @DeleteMapping("/{id}/characters/{characterId}") 
    public ResponseEntity<MovieDetailedDTO> deleteCharacter (@PathVariable Long id,@PathVariable Long characterId) {
        MovieDetailedDTO movie = movieService.deleteCharacter(id,characterId);
        return ResponseEntity.ok().body(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDetailedDTO> update ( @Valid @RequestBody MovieDetailedDTO movie, @PathVariable Long id) {
        MovieDetailedDTO result = movieService.update(id, movie);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}


