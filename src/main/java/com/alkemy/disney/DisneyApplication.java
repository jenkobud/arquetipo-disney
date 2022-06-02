package com.alkemy.disney;


import com.alkemy.disney.mapper.FilmMapper;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.mapper.PersonageMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DisneyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisneyApplication.class, args);
	}
	@Bean
	public PersonageMapper personageMapper(){ return new PersonageMapper(); }
	@Bean
	public FilmMapper filmMapper(){ return new FilmMapper(); }
	@Bean
	public GenreMapper genreMapper(){ return new GenreMapper(); }
}
