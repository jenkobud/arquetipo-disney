package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDto;
import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreMapper genreMapper;

    @Override
    public GenreDto createGenre(Genre genre) {
        GenreDto genreDto = genreMapper.createDTO(genre);
        genreRepository.save(genreMapper.createEntity(genreDto));
        return genreDto;
    }

    @Override
    public List<GenreDto> getGenres() {
        List<Genre> genres = genreRepository.findAll();
        List<GenreDto> genresDto = new ArrayList<GenreDto>();
        genres.forEach(genre -> genresDto.add(genreMapper.createDTO(genre)));
        return genresDto;
    }
}
