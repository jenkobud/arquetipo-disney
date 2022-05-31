package com.alkemy.disney.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "genre")
@Data
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

    protected Genre() {}

    public Genre(String name, String imgUrl, Set<Film> films) {
        this.name = name;
        this.imgUrl = imgUrl;
        this.films = films;
    }

    public Long getId() {
        return id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getName() {
        return name;
    }
}