package com.alkemy.disney.service;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.entity.Film;

import java.util.List;

public interface FilmsService {
    FilmDto createFilm(Film film);
    FilmBasicDto updateFilm(Film film);
    void deleteFilm(Long id);
    FilmDto getFilmById(Long id);
    List<FilmBasicDto> getFilms();
}
