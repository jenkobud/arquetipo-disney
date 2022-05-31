package com.alkemy.disney.service;

import com.alkemy.disney.entity.Film;

import java.util.List;
import java.util.Optional;

public interface FilmsService {
    Film createFilm(Film film);
    List<Film> getFilms();
    Film updateFilm(Film film);
    void deleteFilm(Long id);
}
