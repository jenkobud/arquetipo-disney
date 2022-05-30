package com.alkemy.disney.service;

import com.alkemy.disney.dto.PersonageDto;

public interface IPersonageService {
    public PersonageDto getPersonageById(Long id);
}
