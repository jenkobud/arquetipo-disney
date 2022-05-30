package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import org.aspectj.weaver.patterns.PerObject;
import org.hibernate.validator.constraints.Normalized;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

public class FilmMapper {
    private final PersonageMapper personageMapper = new PersonageMapper();
    private final GenreMapper genreMapper = new GenreMapper();

    public FilmDto createDTO(Film film){

        return new FilmDto(film.getId(),
                film.getTitle(),
                film.getType(),
                film.getRate(),
                genreMapper.createDTO(film.getGenre()),
                getPersonageDtos(film.getPersonages())
                );
    }

    private Set<PersonageDto> getPersonageDtos(Set<Personage> personages) {
        Set<PersonageDto> personageDtoSet = new HashSet<PersonageDto>();
        for (Personage pE : personages.stream().toList()){
            personageDtoSet.add(personageMapper.createDTO(pE));
        }
        return personageDtoSet;
    }

    public Film createEntity(FilmDto filmDto) {
        Film filmEntity = new Film(
                filmDto.getTitle(),
                filmDto.getType(),
                filmDto.getRate(),
                genreMapper.createEntity(filmDto.getGenre()),
                getPersonagesFromPersonageDtoSet(filmDto.getPersonageDto())
        );
        filmEntity.setId(filmDto.getId());
        return filmEntity;
    }

    private Set<Personage> getPersonagesFromPersonageDtoSet(Set<PersonageDto> personageDtos){
        Set<Personage> personagesSet = new HashSet<Personage>();
        for (PersonageDto pDto : personageDtos.stream().toList()){
            personagesSet.add(personageMapper.createEntity(pDto));
        }
        return personagesSet;
    }
}
