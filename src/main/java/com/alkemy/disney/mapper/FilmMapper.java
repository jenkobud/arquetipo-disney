package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class FilmMapper {

    @Autowired
    private PersonageMapper personageMapper;

    @Autowired
    private GenreMapper genreMapper;

    public FilmBasicDto createBasicDTO(Film film){
        return new FilmBasicDto(film.getId(), film.getTitle());
    }
    public FilmDto createDTO(Film film){

        return new FilmDto(film.getId(),
                film.getTitle(),
                film.getType(),
                film.getRate(),
                genreMapper.createDTO(film.getGenre()),
                getPersonageBasicDtos(film.getPersonages())
                );
    }

    public Film createEntity(FilmDto filmDto) {
        Film film = new Film();
        film.setId(filmDto.getId());
        film.setTitle(filmDto.getTitle());
        film.setType(filmDto.getType());
        film.setRate(filmDto.getRate());
        film.setGenre(genreMapper.createEntity(filmDto.getGenre()));
        return film;
    }

    private Set<PersonageBasicDto> getPersonageBasicDtos(Set<Personage> personages) {
        Set<PersonageBasicDto> personageBasicDtoSet = new HashSet<>();
        personages.forEach(personage -> personageBasicDtoSet.add(personageMapper.createBasicDTO(personage)));
        return personageBasicDtoSet;
    }

    public Set<FilmBasicDto> setOfDtos(List<Film> films) {
        Set<FilmBasicDto> filmBasicDtoHashSet = new HashSet<>();
        films.forEach(film -> filmBasicDtoHashSet.add(createBasicDTO(film)));
        return filmBasicDtoHashSet;
    }
}
