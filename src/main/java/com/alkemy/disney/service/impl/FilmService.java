package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import com.alkemy.disney.mapper.FilmMapper;
import com.alkemy.disney.repository.FilmRepository;
import com.alkemy.disney.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FilmService implements IFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public FilmDto getFilmById(Long id) {
        Optional<Film> pFilm = filmRepository.findById(id);
        if(!pFilm.isPresent()) throw new NoSuchElementException();
        return filmMapper.createDTO(pFilm.get());
    }

    @Override
    public List<FilmBasicDto> getFilms() {
        List<Film> films = filmRepository.findAll();
        List<FilmBasicDto> filmBasicDtos = new ArrayList<>();
        films.forEach(film -> filmBasicDtos.add(filmMapper.createBasicDTO(film)));
        return filmBasicDtos;
    }
}
