package com.alkemy.disney.service.impl;

<<<<<<< HEAD
=======
import com.alkemy.disney.dto.FilmBasicDto;
>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
import com.alkemy.disney.dto.FilmDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import com.alkemy.disney.mapper.FilmMapper;
import com.alkemy.disney.repository.FilmRepository;
import com.alkemy.disney.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FilmService implements IFilmService {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmMapper filmMapper;

    @Override
    public FilmDto getFilmById(Long id) {
        Optional<Film> pFilm = filmRepository.findById(id);
        if(!pFilm.isPresent()) throw new NoSuchElementException();
        return filmMapper.createDTO(pFilm.get());
    }
<<<<<<< HEAD
=======

    @Override
    public List<FilmBasicDto> getFilms() {
        List<Film> films = filmRepository.findAll();
        List<FilmBasicDto> filmBasicDtos = new ArrayList<>();
        films.forEach(film -> filmBasicDtos.add(filmMapper.createBasicDTO(film)));
        return filmBasicDtos;
    }
>>>>>>> 9109e66afecc3db08e4638624fe191c4917a4efb
}
