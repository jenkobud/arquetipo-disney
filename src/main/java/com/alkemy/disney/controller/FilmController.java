package com.alkemy.disney.controller;

<<<<<<< HEAD
import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.service.FilmsService;
=======

>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmsService filmsService;

    @PostMapping
    public ResponseEntity<FilmDto> createFilm(@Valid @RequestBody Film film){
        FilmDto filmDto = filmsService.createFilm(film);
        return new ResponseEntity<>(filmDto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FilmBasicDto> updateFilm(@Valid @RequestBody Film film){
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
        return ResponseEntity.status(HttpStatus.OK).body(filmsService.getFilmById(id));

    }
}
