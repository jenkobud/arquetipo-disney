package com.alkemy.disney.service;

import com.alkemy.disney.controller.PersonageController;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IPersonageService {
    public PersonageDto getPersonageById(Long id);

    public List<PersonageBasicDto> getPersonages();
}
