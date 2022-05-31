package com.alkemy.disney.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "film")
@SQLDelete(sql = "UPDATE film SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotEmpty( message = "Title must have a value" )
    protected String title;

    @NotEmpty( message = "Type must have a value" )
    protected String type;

    @Min(value = 1, message = "must be greater or equal to 1")
    protected short rate;

    protected boolean deleted;

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