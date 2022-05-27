package com.alkemy.disney.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class FilmDto implements Serializable {
    private final Long id;
    private final String title;
    private final String type;
    private final short rate;
    private final GenreDto genre;
    private final Set<PersonageBasicDto> personageDto;
}
