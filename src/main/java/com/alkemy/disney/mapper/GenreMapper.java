package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Genre;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenreMapper {

    public GenreDto createDTO(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName(), genre.getImgUrl());
    }

    public Genre createEntity(GenreDto genreDto) {
        Genre genre = new Genre();
        genre.setId(genreDto.getId());
        genre.setName(genreDto.getName());
        genre.setImgUrl(genreDto.getImgUrl());
        return genre;
    }

    public Set<GenreDto> setOfDtos(List<Genre> genres) {
        Set<GenreDto> genreDtoHashSet = new HashSet<>();
        genres.forEach(genre -> genreDtoHashSet.add(createDTO(genre)));
        return genreDtoHashSet;
    }
}
