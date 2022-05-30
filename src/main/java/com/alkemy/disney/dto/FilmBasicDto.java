package com.alkemy.disney.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilmBasicDto implements Serializable {
    private final Long id;
    private final String title;
}
