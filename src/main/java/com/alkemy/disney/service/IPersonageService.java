package com.alkemy.disney.service;

import com.alkemy.disney.controller.PersonageController;
import com.alkemy.disney.dto.PersonageDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface IPersonageService {
    public PersonageDto getPersonageById(Long id);
}
