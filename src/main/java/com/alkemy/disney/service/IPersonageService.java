package com.alkemy.disney.service;

import com.alkemy.disney.controller.PersonageController;
import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonageService {
    public PersonageDto getPersonageById(Long id);

    public List<PersonageBasicDto> getPersonages();
}
