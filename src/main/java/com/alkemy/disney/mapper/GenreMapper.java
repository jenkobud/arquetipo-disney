package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import java.util.Optional;

import java.util.Optional;

public class GenreMapper {
    @Autowired
    private GenreRepository genreRepository;

    public GenreDto createDTO(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName(), genre.getImgUrl());
    }

<<<<<<< HEAD
<<<<<<< HEAD
    public Genre createEntity(GenreDto genreDto) {
        Optional<Genre> genreOptional = genreRepository.findById(genreDto.getId());
        if(!genreOptional.isPresent()) throw new NullPointerException();
        return genreOptional.get();
    }
=======
    public Genre createEntity(GenreDto genre) {throw new NotImplementedException();}
>>>>>>> 5da8210c3567c2beeca91c73e4e9973db360e326
=======
    public Genre createEntity(GenreDto genre) {throw new NotImplementedException();}
>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
}
