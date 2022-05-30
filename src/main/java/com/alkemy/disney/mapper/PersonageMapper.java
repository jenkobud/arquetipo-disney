package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;

import java.util.HashSet;
import java.util.Set;

public class PersonageMapper {
    public final FilmMapper filmMapper = new FilmMapper();
    public PersonageBasicDto createBasicDto(Personage pEntity){
        return (new PersonageBasicDto(pEntity.getId(), pEntity.getName(), pEntity.getImgUrl()));
    }
    public PersonageDto createDTO(Personage pEntity){

        PersonageDto pDto = new PersonageDto(
                pEntity.getId(),
                pEntity.getName(),
                pEntity.getHistory(),
                pEntity.getImgUrl(),
                pEntity.getAge(),
                pEntity.getWeight(),
                getFilmDtosOfPersonage(pEntity.getFilms())
        );

        return pDto;
    }
    public Personage createEntity(PersonageDto pDto){

        Personage pEntity = new Personage(pDto.getName(),
                pDto.getHistory(),
                pDto.getImgUrl(),
                pDto.getAge(),
                pDto.getWeight(),
                getFilmsFromPersonajeDto(pDto.getFilmsDto()));

        pEntity.setId(pDto.getId());
        return pEntity;
    }
    private Set<Film> getFilmsFromPersonajeDto(Set<FilmDto> filmsDto) {
        Set<Film> films = new HashSet<Film>();
        for (FilmDto filmDto : filmsDto.stream().toList()){
            films.add(filmMapper.createEntity(filmDto));
        }
        return films;
    }
    private Set<FilmDto> getFilmDtosOfPersonage(Set<Film> films){
        Set<FilmDto> filmDtos = new HashSet<FilmDto>();
        for (Film film : films.stream().toList()){
            filmDtos.add(filmMapper.createDTO(film));
        }
        return filmDtos;
    }
}
