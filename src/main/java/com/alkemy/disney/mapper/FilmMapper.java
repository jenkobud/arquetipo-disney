package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import com.alkemy.disney.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FilmMapper {

    @Autowired
    private FilmRepository filmRepository;
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

    public Film createEntity(FilmBasicDto filmBasicDto){
        Optional<Film> filmOptional = filmRepository.findById(filmBasicDto.getId());
        if(!filmOptional.isPresent()) throw new NullPointerException(); //Change for a more specific Exception BORRAR
        return filmOptional.get();
    }
    public Film createEntity(FilmDto filmDto) {
        Film filmEntity = new Film(
                filmDto.getTitle(),
                filmDto.getType(),
                filmDto.getRate(),
                genreMapper.createEntity(filmDto.getGenre()),
                getPersonagesFromPersonageDtoSet(filmDto.getPersonages())
        );
        filmEntity.setId(filmDto.getId());
        return filmEntity;
    }

    private Set<Personage> getPersonagesFromPersonageDtoSet(Set<PersonageBasicDto> personageBasicDtos){
        Set<Personage> personagesSet = new HashSet<Personage>();
        personageBasicDtos.forEach(personageBasicDto -> {
            personagesSet.add(personageMapper.createEntity(personageBasicDto));
        });
        return personagesSet;
    }

    private Set<PersonageBasicDto> getPersonageBasicDtos(Set<Personage> personages) {
        Set<PersonageBasicDto> personageBasicDtoSet = new HashSet<PersonageBasicDto>();
        personages.forEach(personage -> personageMapper.createBasicDTO(personage));
        return personageBasicDtoSet;
    }
}
