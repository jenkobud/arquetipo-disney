package com.alkemy.disney.service.impl;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.repository.FilmRepository;
import com.alkemy.disney.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmsServiceImpl implements FilmsService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film createFilm(Film film) {
        return this.filmRepository.save(film);
    }

    @Override
    public Film updateFilm(Film film) {
        return this.filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}
