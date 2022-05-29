package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {
    @Autowired
    private GenreRepository genreRepository;

    @PostMapping("/genre")
    public Genre createGenre(@RequestBody Genre genre){
        return genreRepository.save(genre);
    }
}
