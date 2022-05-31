package com.alkemy.disney.controller;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.service.impl.FilmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmsServiceImpl filmsServiceImpl;

    @GetMapping
    public List<Film> getAllFilms(){
        return filmsServiceImpl.getFilms();
    }

    @PostMapping
    public Film createFilm(@Valid @RequestBody Film film){
        return filmsServiceImpl.createFilm(film);
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film){
        return filmsServiceImpl.updateFilm(film);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteFilm(@PathVariable Long id){
         filmsServiceImpl.deleteFilm(id);
    }
}
