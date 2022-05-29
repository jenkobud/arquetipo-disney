package com.alkemy.disney.service;

import com.alkemy.disney.entity.Genre;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.impl.GenreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*
 * @author VariniaQuisbert
 * @version 1.0 27-05-22
 * This interface contains business logic methods for genres
 */
@Service
public interface GenreService  {
    Genre createGenre(Genre genre);
}
