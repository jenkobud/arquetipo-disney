package com.alkemy.disney.service;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;

import java.util.List;

public interface FilmsService {
    FilmDto createFilm(FilmDto film);
    FilmBasicDto updateFilm(FilmBasicDto film);
    void deleteFilm(Long id);
    FilmDto getFilmById(Long id);
    List<FilmBasicDto> getFilms();
    FilmDto removePersonageFromMovie(Long idFilm, Long idPersonage);
}
