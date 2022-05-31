package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.mapper.FilmMapper;
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

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public FilmDto createFilm(Film film) {
        FilmDto filmDto = filmMapper.createDTO(film);
        filmRepository.save(filmMapper.createEntity(filmDto));
        return filmDto;
    }

    @Override
    public FilmBasicDto updateFilm(Film film) {
        FilmBasicDto filmBasicDto = filmMapper.createBasicDTO(film);
        filmRepository.save(filmMapper.createEntity(filmBasicDto));
        return filmBasicDto;
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }
}
