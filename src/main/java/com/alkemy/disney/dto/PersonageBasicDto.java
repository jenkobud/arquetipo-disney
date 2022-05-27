package com.alkemy.disney.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonageBasicDto implements Serializable {
    private final String name;
    private final String imgUrl;
}
