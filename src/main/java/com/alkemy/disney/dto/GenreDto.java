package com.alkemy.disney.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Data
public class GenreDto implements Serializable {
    @NotNull
    private final Long id;
    @NotBlank(message = "This field can't be blank")
    private final String name;
    @NotBlank(message = "This field can't be blank")
    private final String imgUrl;

    public GenreDto(Long id, String name, String imgUrl) {
        this.id = id;
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }
}
