package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping
    @ResponseBody
    public List<GenreDto> getGenres(){
        return genreService.getGenres();
    }

    @PostMapping
    public ResponseEntity<GenreDto> createGenre(@Valid @RequestBody GenreDto genreDto){
        GenreDto genreDtoRes = genreService.createGenre(genreDto);
        return new ResponseEntity<>(genreDtoRes, HttpStatus.CREATED);
    }
}
