package com.alkemy.disney.service.impl;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.repository.FilmRepository;
import com.alkemy.disney.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmsServiceImpl implements FilmsService {
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public Film createFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }

    @Override
    public Film updateFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}
