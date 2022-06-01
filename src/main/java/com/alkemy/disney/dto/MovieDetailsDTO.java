package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.format.annotation.DateTimeFormat;

@Setter @Getter
public final class MovieDetailsDTO {
    @NotBlank(message = "is required")
    private String title;
    
    @NotBlank(message = "is required") @URL(message = "URL is not valid")
    private String image;
    
    @NotNull(message = "is required") @Past(message = "is future") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date realasedDate;
    
    @NotNull(message = "is required") @Min(value = 1, message = "the minimum is 1") @Max(value = 5, message = "the maximum is 5")
    private Integer calification;
    
    @NotNull(message = "is required")
    private GenreEntity genre; 
    
    @NotEmpty(message = "at least must exist one")
    private Set<CharacterEntity> characters = new HashSet<>();
}