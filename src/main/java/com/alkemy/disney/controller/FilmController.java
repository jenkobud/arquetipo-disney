package com.alkemy.disney.controller;


<<<<<<< HEAD
=======
import com.alkemy.disney.dto.FilmBasicDto;
>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb

@Controller
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private IFilmService filmService;

<<<<<<< HEAD
=======
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<FilmBasicDto>> getFilms(){
        return ResponseEntity.status(HttpStatus.OK).body(filmService.getFilms());
    }

>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<FilmDto> getFilmById(@Valid @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(filmService.getFilmById(id));
    }
}
