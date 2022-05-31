package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Personage;
import com.alkemy.disney.mapper.PersonageMapper;
import com.alkemy.disney.repository.PersonageRepository;
import com.alkemy.disney.service.IPersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonageService implements IPersonageService {

    @Autowired
    private PersonageRepository personageRepository;

    @Autowired
    private PersonageMapper personageMapper;


    @Override
    public List<PersonageBasicDto> getPersonages(){
        List<Personage> personages = personageRepository.findAll();
        List<PersonageBasicDto> personagesBasicDtoList = new ArrayList<PersonageBasicDto>();
        personages.forEach(personage -> personagesBasicDtoList.add(personageMapper.createBasicDTO(personage)));
        return personagesBasicDtoList;
    }

    @Override
    public PersonageDto getPersonageById(Long id){
        Optional<Personage> pOptional = personageRepository.findById(id);
        if(!pOptional.isPresent()) return null;
        return  personageMapper.createDTO(pOptional.get());
    }
}
