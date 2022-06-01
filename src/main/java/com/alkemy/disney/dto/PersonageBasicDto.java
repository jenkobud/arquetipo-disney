package com.alkemy.disney.dto;

import com.alkemy.disney.exception.ErrorMessage;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Getter
@Setter
@Data
public class PersonageBasicDto implements Serializable {

    @NotNull( message = ErrorMessage.ID_NOT_NULL)
    private final Long id;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String name;
    @NotBlank(message = ErrorMessage.ATRIBUTE_NOT_BLANK)
    private final String imgUrl;
}
