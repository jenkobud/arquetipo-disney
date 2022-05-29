package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;
import com.alkemy.disney.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    private GenreServiceImpl genreService;

    @PostMapping
    public Genre createGenre(@RequestBody Genre genre){
        return this.genreService.createGenre(genre);
    }
}
