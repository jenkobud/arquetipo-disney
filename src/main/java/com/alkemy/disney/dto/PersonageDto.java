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
public class PersonageDto implements Serializable {

    @NotNull(message = ErrorMessage.ID_NOT_NULL)
    private final Long id;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String name;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String history;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String imgUrl;
    @Min(value = 0, message = ErrorMessage.AGE_MIN)
    @Max(value = 150, message = ErrorMessage.AGE_MAX)
    private final Short age;
    @Positive(message = ErrorMessage.WEIGHT_MIN)
    @Max(value=400 ,message = ErrorMessage.WEIGHT_MAX )
    private final Short weight;
    @NotNull( message = ErrorMessage.ATRIBUTE_NOT_NULL)
    private final Set<FilmBasicDto> films;
}
