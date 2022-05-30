package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;

import java.util.Set;

public class FilmMapper {
    private PersonageMapper personageMapper = new PersonageMapper();
//    private final Long id;
//    private final String title;
//    private final String type;
//    private final short rate;
//    private final GenreDto genre;
//    private final Set<PersonageBasicDto> personageDto;
    public FilmDto createDTO(Film film){

        return new FilmDto(film.getId(),
                film.getTitle(),
                film.getType(),
                film.getRate(),
                film.getGenre(),
                getPersonageBasicDtos(film.getPersonages())
                );
    }

    private Set<PersonageBasicDto> getPersonageBasicDtos(Set<Personage> personages) {
        return null;
    }
}
