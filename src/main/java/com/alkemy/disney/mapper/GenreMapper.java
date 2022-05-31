package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.exception.NotImplementedException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenreMapper {
    public GenreDto createDTO(Genre genre) {
        return new GenreDto(genre.getId(), genre.getName(), genre.getImgUrl());
    }

    public Genre createEntity(GenreDto genre) { throw new NotImplementedException(); }
}
