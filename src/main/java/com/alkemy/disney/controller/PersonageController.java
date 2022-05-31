package com.alkemy.disney.controller;

import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.service.IPersonageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/characters")
public class PersonageController {
    @Autowired
    private IPersonageService personageService;


    //Correct return
    // return ResponseEntity.status(HttpStatus.CREATED).body(action)
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<PersonageBasicDto>> getPersonages(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(personageService.getPersonages());
        //return personageService.getPersonages();
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<PersonageDto> getPersonage(@Valid @PathVariable("id") Long id){

        //return personageService.getPersonageById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(personageService.getPersonageById(id));
    }
}
