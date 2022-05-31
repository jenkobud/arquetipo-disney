package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;
import com.alkemy.disney.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreServiceImpl genreService;

    @Autowired
    private GenreMapper genreMapper;

    @PostMapping
    public ResponseEntity<GenreDto> createGenre(@RequestBody GenreDto genreDto){
        Genre genre = genreService.createGenre(genreMapper.createEntity(genreDto));
        return new ResponseEntity<>(genreMapper.createDTO(genre), HttpStatus.OK);
    }
}
