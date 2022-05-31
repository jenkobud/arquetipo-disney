package com.alkemy.disney.service;

import com.alkemy.disney.controller.PersonageController;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IPersonageService {

    PersonageDto save(PersonageDto personageDto);

    PersonageDto delete(Long id);

    PersonageDto update(Long id, PersonageDto personage);
    public PersonageDto getPersonageById(Long id);
    public List<PersonageBasicDto> getPersonages();
}
