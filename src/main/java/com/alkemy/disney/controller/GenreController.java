package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.service.GenreService;
import com.alkemy.disney.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
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
    public ResponseEntity<GenreDto> createGenre(@Valid @RequestBody Genre genre){
        GenreDto genreDto = genreService.createGenre(genre);
        return new ResponseEntity<>(genreDto, HttpStatus.OK);
    }
}
