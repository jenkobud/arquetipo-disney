package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@Getter
@Setter
@Table(name = "personage")
public class Personage {

    //This class is named 'personage' instead of 'character' because DB was having problems creating a table called 'character'...
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String name, history;
    @Column(name = "img_url")
    protected String imgUrl;
    protected Short age, weight;

    @ManyToMany(mappedBy ="personages",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    protected Set<Film> films;
    protected Personage() {}

    public Personage(String name, String history, String imgUrl, Short age, Short weight, Set<Film> films) {
        this.name = name;
        this.history = history;
        this.imgUrl = imgUrl;
        this.age = age;
        this.weight = weight;
        this.films = films;
    }
}