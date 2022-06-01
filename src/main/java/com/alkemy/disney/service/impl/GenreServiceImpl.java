package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.exception.EntityAlreadyExistsException;
import com.alkemy.disney.exception.ErrorMessage;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreMapper genreMapper;

    @Override
    public GenreDto createGenre(GenreDto genreDto) {
        if(genreRepository.findById(genreDto.getId()).isPresent()) throw new EntityAlreadyExistsException(ErrorMessage.ENTITY_ALREADY_EXIST);
        Genre g = genreMapper.createEntity(genreDto);
        g.setFilms(new HashSet<>());
        genreRepository.save(g);
        return genreDto;
    }

    @Override
    public List<GenreDto> getGenres() {
        return (genreMapper.setOfDtos(genreRepository.findAll()).stream().toList());
    }

}
