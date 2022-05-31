package com.alkemy.disney.service;

import com.alkemy.disney.dto.FilmDto;
import org.springframework.stereotype.Service;

@Service
public interface IFilmService {
    FilmDto getFilmById(Long id);
}
