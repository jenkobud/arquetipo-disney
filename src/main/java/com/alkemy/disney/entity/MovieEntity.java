package com.alkemy.disney.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "movies")
@Getter @Setter
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String title;
    @Column
    private String image;
    @Column (nullable = false, name = "realesed_date")
    private Date realasedDate;
    @Column (nullable = false)
    private Integer calification;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinColumn(name = "genre_id", nullable = false)
    private GenreEntity genre;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH
    })
    @JoinTable(
            name="movies_characters",
            joinColumns = {@JoinColumn(name="movie_id")},
            inverseJoinColumns = {@JoinColumn(name="character_id")}
    )
    private List<CharacterEntity> characters;

    public MovieEntity (){
        characters = new ArrayList<>();
    }

    public MovieEntity(Long id, String title, String image, Date realasedDate, Integer calification, GenreEntity genre, List<CharacterEntity> characters) {
        super();
        this.id = id;
        this.title = title;
        this.image = image;
        this.realasedDate = realasedDate;
        this.calification = calification;
        this.genre = genre;
        this.characters = characters;
    }

    public MovieEntity(String title, String image, Date realasedDate, Integer calification, GenreEntity genre, List<CharacterEntity> characters) {
        super();
        this.title = title;
        this.image = image;
        this.realasedDate = realasedDate;
        this.calification = calification;
        this.genre = genre;
        this.characters = characters;
    }
    
    public void addCharacter (CharacterEntity character) {
        characters.add(character);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", realasedDate=" + realasedDate +
                ", calification=" + calification +
                ", genre=" + genre +
                ", characters=" + characters +
                '}';
    }
}