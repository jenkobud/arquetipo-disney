package com.alkemy.disney.controller;

import com.alkemy.disney.dto.PersonageBasicDto;
import com.alkemy.disney.dto.PersonageDto;
import com.alkemy.disney.mapper.PersonageMapper;
import com.alkemy.disney.service.IPersonageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping("/characters")
public class PersonageController {
    @Autowired
    private IPersonageService personageService;


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
