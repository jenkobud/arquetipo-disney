package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name, imgUrl;

    @OneToMany(mappedBy="genre",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    protected Set<Film> films;

    public Genre() {}

    public Genre(String name, String imgUrl, Set<Film> films) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.films = films;
    }
}