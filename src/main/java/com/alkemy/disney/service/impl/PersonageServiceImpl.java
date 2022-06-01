package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.entity.Personage;
import com.alkemy.disney.exception.EntityAlreadyExistsException;
import com.alkemy.disney.exception.ErrorMessage;
import com.alkemy.disney.exception.NotFoundOnDataBaseException;
import com.alkemy.disney.mapper.PersonageMapper;
import com.alkemy.disney.repository.PersonageRepository;
import com.alkemy.disney.service.IPersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonageServiceImpl implements IPersonageService {

    @Autowired
    private PersonageRepository personageRepository;

    @Autowired
    private PersonageMapper personageMapper;

    @Override
    public PersonageDto save(PersonageDto personageDto){
        if(personageRepository.findById(personageDto.getId()).isPresent()) throw new EntityAlreadyExistsException(ErrorMessage.ENTITY_ALREADY_EXIST);
        Personage personageEntity = personageMapper.createEntity(personageDto);
        Personage personageSaved = personageRepository.save(personageEntity);
        return personageMapper.createDTO(personageSaved);
    }

    @Override
    public PersonageDto delete(Long id){
        Personage personage = personageRepository.findById(id).orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));
        personageRepository.deleteById(id);
        return personageMapper.createDTO(personage);
    }

    public PersonageDto update(Long id, PersonageDto personageDto){
        if(personageRepository.findById(personageDto.getId()).isEmpty()) throw new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB);
        personageRepository.save(personageMapper.createEntity(personageDto));
        return personageDto;

    }
    @Override
    public List<PersonageBasicDto> getPersonages(){
        return (personageMapper.setOfDtos(personageRepository.findAll()).stream().toList());
    }

    @Override
    public PersonageDto getPersonageById(Long id){
        Personage p = personageRepository.findById(id)
                .orElseThrow(() -> new NotFoundOnDataBaseException(ErrorMessage.NO_RETRIEVE_FROM_DB));
        return  personageMapper.createDTO(p);
    }
}
