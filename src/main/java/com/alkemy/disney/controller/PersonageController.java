package com.alkemy.disney.controller;

import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.service.PersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class PersonageController {
    @Autowired
    private PersonageService personageService;


    @GetMapping
    @ResponseBody
    public List<PersonageBasicDto> getPersonages(){
        return personageService.getPersonages();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public PersonageDto getPersonage(@PathVariable("id") Long id){
        return personageService.getPersonageById(id);
    }


    @PostMapping
    //@PostMapping(/create) //<- NO REST
    public ResponseEntity<PersonageDto> save(@Valid @RequestBody PersonageDto personage){
        PersonageDto savedPersonage = personageService.save(personage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonage);
    }

    @PutMapping("/{id}")
    //@PutMapping("modify/{id}") //<- NO REST
    public ResponseEntity<PersonageDto> update(@PathVariable Long id, @Valid @RequestBody PersonageDto personage){
        PersonageDto newPersonage = personageService.update(id, personage);
        return ResponseEntity.ok().body(newPersonage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonageDto> delete(@PathVariable long id){
        PersonageDto deletedPersonage = personageService.delete(id);
        return ResponseEntity.ok().body(deletedPersonage);
    }
}
