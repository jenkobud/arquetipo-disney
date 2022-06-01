package com.alkemy.disney.service;

import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonageService {

    PersonageDto save(PersonageDto personageDto);

    PersonageDto delete(Long id);

    PersonageDto update(Long id, PersonageDto personage);
    public PersonageDto getPersonageById(Long id);
    public List<PersonageBasicDto> getPersonages();
}
