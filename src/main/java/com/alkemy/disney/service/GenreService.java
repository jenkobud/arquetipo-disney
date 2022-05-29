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
public class GenreService implements GenreServiceImpl {
    @Autowired
    private GenreRepository data;

    @Override
    public int save(Genre genre) {
        int res = 0;
        Genre g = data.save(genre);
        if (!g.equals(null)) {res=1;}
        return res;
    }
}
