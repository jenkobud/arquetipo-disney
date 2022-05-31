package com.alkemy.disney.service;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IFilmService {
    FilmDto getFilmById(Long id);

    List<FilmBasicDto> getFilms();
}
