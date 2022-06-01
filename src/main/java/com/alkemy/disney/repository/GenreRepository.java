package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
* @author VariniaQuisbert
* @version 1.0 27-05-22
* This interface contains the CRUD methods with Spring JPA for genre entity
*/
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
}