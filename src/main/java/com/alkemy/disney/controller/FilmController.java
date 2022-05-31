package com.alkemy.disney.controller;


import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private IFilmService filmService;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<FilmDto> getFilmById(@Valid @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(filmService.getFilmById(id));
    }
}
