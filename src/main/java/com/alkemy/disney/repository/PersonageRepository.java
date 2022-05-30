package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Film;
import com.alkemy.disney.entity.Personage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonageRepository extends JpaRepository<Personage, Long> {

    //List<Film> getFilms(Long id);
}