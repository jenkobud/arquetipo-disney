package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Personage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonageRepository extends JpaRepository<Personage, Long> {
}