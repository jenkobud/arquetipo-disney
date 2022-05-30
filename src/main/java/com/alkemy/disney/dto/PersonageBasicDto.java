package com.alkemy.disney.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Data
public class PersonageBasicDto implements Serializable {

    private final Long id;
    private final String name;
    private final String imgUrl;
}
