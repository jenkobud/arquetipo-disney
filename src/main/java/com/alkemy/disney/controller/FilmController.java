package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.service.impl.FilmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmsServiceImpl filmsService;

    @PostMapping
    public Film createFilm(@RequestBody Film film){
        return this.filmsService.createFilm(film);
    }

    @PutMapping
    public Film updateFilm(@RequestBody Film film){
        return this.filmsService.updateFilm(film);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(Long id){
         this.filmsService.deleteFilm(id);
    }
}
