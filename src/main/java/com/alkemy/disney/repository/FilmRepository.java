package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}