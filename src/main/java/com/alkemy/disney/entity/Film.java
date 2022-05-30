package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String title, type;
    protected short rate;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="GENRE_ID", nullable=true)
    protected Genre genre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "film_personage",
            joinColumns = {@JoinColumn(name="film_id")},
            inverseJoinColumns = {@JoinColumn(name = "personage_id")}
    )
    protected Set<Personage> personages;
    protected Film() {}

    public Film(String title, String type, short rate, Genre genre, Set<Personage> personages) {
        this.title = title;
        this.type = type;
        this.rate = rate;
        this.genre = genre;
        this.personages = personages;
    }
}