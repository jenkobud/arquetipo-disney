package com.alkemy.disney.dto;

import com.alkemy.disney.exception.ErrorMessage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Data
public class FilmDto implements Serializable {
    @NotNull(message = ErrorMessage.ID_NOT_NULL)
    private final Long id;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String title;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String type;
    @Size(min = 0, max = 5)
    private final short rate;
    @NotNull(message = ErrorMessage.ATRIBUTE_NOT_NULL)
    private final GenreDto genre;
    @NotNull(message = ErrorMessage.ATRIBUTE_NOT_NULL)
    @Size(min = 1)
    private final Set<PersonageBasicDto> personages;
}
