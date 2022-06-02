package com.alkemy.disney.controller;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class FilmController {

    @Autowired
    private FilmsService filmsService;

    @PostMapping
    public ResponseEntity<FilmDto> createFilm(@Valid @RequestBody FilmDto filmDto){
        filmsService.createFilm(filmDto);
        return new ResponseEntity<>(filmDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FilmBasicDto> updateFilm(@Valid @RequestBody FilmBasicDto film){
        FilmBasicDto filmBasicDto = filmsService.updateFilm(film);
        return new ResponseEntity<>(filmBasicDto, HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmsService.deleteFilm(id);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<FilmBasicDto>> getFilms(){
        return ResponseEntity.status(HttpStatus.OK).body(filmsService.getFilms());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<FilmDto> getFilmById(@Valid @PathVariable("id") Long id){
        FilmDto filmDto = filmsService.getFilmById(id);
        return ResponseEntity.status(HttpStatus.OK).body(filmDto);
    }

    @DeleteMapping
    @RequestMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<FilmDto> removePersonageFromMovie (@PathVariable Long idMovie, @PathVariable Long idPersonage){
        FilmDto filmDto = filmsService.removePersonageFromMovie(idMovie, idPersonage);
        return ResponseEntity.status(HttpStatus.OK).body(filmDto);
    }
}
