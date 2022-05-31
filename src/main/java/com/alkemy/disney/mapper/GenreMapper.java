package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.exception.NotImplementedException;
import com.alkemy.disney.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GenreMapper {
    @Autowired
    private GenreRepository genreRepository;

    public GenreDto createDTO(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName(), genre.getImgUrl());
    }

    public Genre createEntity(GenreDto genre) {

        Optional<Genre> genreOptional = genreRepository.findById(GenreDto.getId());
        if(!genreOptional.isPresent()) throw new NullPointerException(); //TODO Change for a more specific exception
        return genreOptional.get();
    }
}
