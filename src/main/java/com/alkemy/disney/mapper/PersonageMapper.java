package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class PersonageMapper {


    @Autowired
    private FilmMapper filmMapper;
    public PersonageBasicDto createBasicDTO(Personage pEntity){
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
                getFilmBasicDtos(pEntity.getFilms())
        );

        return pDto;
    }

    public Personage createEntity(PersonageDto pDto){

        Personage pEntity = new Personage(pDto.getName(),
                pDto.getHistory(),
                pDto.getImgUrl(),
                pDto.getAge(),
                pDto.getWeight(),
                new HashSet<>());

        pEntity.setId(pDto.getId());
        return pEntity;
    }
    private Set<FilmBasicDto> getFilmBasicDtos(Set<Film> films){
        Set<FilmBasicDto> filmDtos = new HashSet<>();
        films.forEach(film -> filmDtos.add(filmMapper.createBasicDTO(film)));
        return filmDtos;
    }

    public Set<PersonageBasicDto> setOfDtos(List<Personage> personages) {
        Set<PersonageBasicDto> personageBasicDtoHashSet = new HashSet<>();
        personages.forEach(personage -> personageBasicDtoHashSet.add(createBasicDTO(personage)));
        return personageBasicDtoHashSet;
    }
}
