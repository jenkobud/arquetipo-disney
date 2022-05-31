package com.alkemy.disney.service;

<<<<<<< HEAD
import com.alkemy.disney.dto.FilmDto;
import org.springframework.stereotype.Service;

@Service
public interface IFilmService {
    FilmDto getFilmById(Long id);
=======
import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFilmService {
    FilmDto getFilmById(Long id);

    List<FilmBasicDto> getFilms();
>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
}
