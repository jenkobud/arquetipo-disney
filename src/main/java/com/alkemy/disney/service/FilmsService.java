package com.alkemy.disney.service;

import com.alkemy.disney.entity.Film;

public interface FilmsService {
    Film createFilm(Film film);
    Film updateFilm(Film film);
    void deleteFilm(Long id);
}
