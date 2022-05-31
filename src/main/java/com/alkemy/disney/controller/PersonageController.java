package com.alkemy.disney.controller;

import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.mapper.PersonageMapper;
import com.alkemy.disney.service.IPersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/characters")
public class PersonageController {
    @Autowired
    private IPersonageService personageService;
    @PostMapping("/create")
    public ResponseEntity<PersonageDto> save(@RequestBody PersonageDto personage){
        PersonageDto savedPersonage = personageService.save(personage);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPersonage);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<PersonageDto> update(@PathVariable Long id, @RequestBody PersonageDto personage){
        PersonageDto newPersonage = personageService.update(id, personage);
        return ResponseEntity.ok().body(newPersonage);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<PersonageDto> delete(@PathVariable long id){
        PersonageDto deletedPersonage = personageService.delete(id);
        return ResponseEntity.ok(deletedPersonage);
    }
    @GetMapping()
    @ResponseBody
    public List<PersonageBasicDto> getPersonages(){
        return personageService.getPersonages();
    }
    @GetMapping(value = "/{id}")
    @ResponseBody
    public PersonageDto getPersonage(@PathVariable("id") Long id){
        return personageService.getPersonageById(id);
    }
}
