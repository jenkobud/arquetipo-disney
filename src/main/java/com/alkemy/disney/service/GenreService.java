package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenreDto;

import java.util.List;

/*
 * @author VariniaQuisbert
 * @version 1.0 27-05-22
 * This interface contains business logic methods for genres
 */

public interface GenreService  {
    GenreDto createGenre(GenreDto genre);
    List<GenreDto> getGenres();
}
