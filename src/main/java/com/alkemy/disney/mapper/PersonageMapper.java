package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import com.alkemy.disney.repository.PersonageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class PersonageMapper {

    @Autowired
    PersonageRepository personageRepository;

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

    public Personage createEntity(PersonageBasicDto pBasicDto){
        Optional<Personage> personageOptional = personageRepository.findById(pBasicDto.getId());
        if(!personageOptional.isPresent()) throw new NoSuchElementException();
        return personageOptional.get();
    }
    public Personage createEntity(PersonageDto pDto){

        Personage pEntity = new Personage(pDto.getName(),
                pDto.getHistory(),
                pDto.getImgUrl(),
                pDto.getAge(),
                pDto.getWeight(),
                getFilmsFromDtos(pDto.getFilms()));

        pEntity.setId(pDto.getId());
        return pEntity;
    }
    private Set<Film> getFilmsFromDtos(Set<FilmBasicDto> filmsDto) {
        Set<Film> films = new HashSet<Film>();
        filmsDto.forEach(filmBasicDto -> films.add(filmMapper.createEntity(filmBasicDto)));
        return films;
    }
    private Set<FilmBasicDto> getFilmBasicDtos(Set<Film> films){
        Set<FilmBasicDto> filmDtos = new HashSet<FilmBasicDto>();
        films.forEach(film -> filmDtos.add(filmMapper.createBasicDTO(film)));
        return filmDtos;
    }
}
