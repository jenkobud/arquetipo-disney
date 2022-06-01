package com.alkemy.disney.dto;

import com.alkemy.disney.exception.ErrorMessage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Data
public class FilmDto implements Serializable {
    @NotNull(message = ErrorMessage.ID_NOT_NULL)
    private final Long id;
    @NotBlank( message = ErrorMessage.ATRIBUTE_NOT_BLANK )
    private final String title;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String type;
    @Min(value = 0, message = ErrorMessage.RATE_RANGE)
    @Max(value = 10, message = ErrorMessage.RATE_RANGE)
    private final short rate;
    @NotNull(message = ErrorMessage.ATRIBUTE_NOT_NULL)
    private final GenreDto genre;
    @NotEmpty(message = ErrorMessage.ATRIBUTE_NOT_EMPTY)
    private final Set<PersonageBasicDto> personages;
}
