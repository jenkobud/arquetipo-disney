package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.FilmBasicDto;
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import com.alkemy.disney.exception.ErrorMessage;
import com.alkemy.disney.exception.NotFoundOnDataBaseException;
import com.alkemy.disney.mapper.FilmMapper;
import com.alkemy.disney.mapper.PersonageMapper;
import com.alkemy.disney.repository.FilmRepository;
import com.alkemy.disney.repository.PersonageRepository;
import com.alkemy.disney.service.FilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class FilmsServiceImpl implements FilmsService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private PersonageRepository personageRepository;

    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private PersonageMapper personageMapper;

    @Override
    public FilmDto createFilm(FilmDto filmDto) {
        Film film = filmMapper.createEntity(filmDto);
        Set<Personage> personagesSet = new HashSet<>();
        filmDto.getPersonages().forEach(personageBasicDto -> personagesSet.add(personageMapper.createEntity(convertBasicDto2Dto(personageBasicDto))));
        film.setPersonages(personagesSet);
        filmRepository.save(film);
        return filmDto;
    }

    @Override
    public FilmBasicDto updateFilm(FilmBasicDto filmBasicDto) {
        filmRepository.save(filmMapper.createEntity(convertBasicDto2Dto(filmBasicDto)));
        return filmBasicDto;
    }

    @Override
    public void deleteFilm(Long id) {
        filmRepository.deleteById(id);
    }

    @Override
    public FilmDto getFilmById(Long id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));
        return filmMapper.createDTO(film);
    }

    @Override
    public List<FilmBasicDto> getFilms() {
        return (filmMapper.setOfDtos(filmRepository.findAll()).stream().toList());
    }

    private FilmDto convertBasicDto2Dto(FilmBasicDto fBDto){
        Film f = filmRepository.findById(fBDto.getId())
                .orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));
        f.setTitle(fBDto.getTitle());
        return filmMapper.createDTO(f);
    }

    private PersonageDto convertBasicDto2Dto(PersonageBasicDto pBDto){
        Personage p = personageRepository.findById(pBDto.getId())
                .orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));
        p.setName(pBDto.getName());
        p.setName(pBDto.getName());
        p.setImgUrl(pBDto.getImgUrl());
        return personageMapper.createDTO(p);
    }

    @Override
    public FilmDto addPersonage(long idFilm, long idCharacter) {
        Personage personage = personageRepository.findById(idCharacter)
                .orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));

        Film film = filmRepository.findById(idFilm)
                .orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));

        film.addPersonage(personage);

        // update database
        filmRepository.save(film);
        return filmMapper.createDTO(film);
    }
  
    public FilmDto removePersonageFromMovie(Long idFilm, Long idPersonage){
        Film film = filmRepository.findById(idFilm).orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));
        Personage personageToRemove = personageRepository.findById(idPersonage).orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));
        film.removePersonage(personageToRemove);
        filmRepository.save(film);
        return filmMapper.createDTO(film);
    }
}
