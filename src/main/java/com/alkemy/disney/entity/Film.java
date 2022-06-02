package com.alkemy.disney.entity;

import com.alkemy.disney.exception.EntityAlreadyExistsException;
import com.alkemy.disney.exception.ErrorMessage;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
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
    protected String title;
    protected String type;
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
    public Film() {}

    public void addPersonage(Personage personage){
        if (this.personages.contains(personage)){
            throw new EntityAlreadyExistsException(ErrorMessage.ENTITY_ALREADY_EXIST);
        }
        this.personages.add(personage);
    }
}