package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.dto.MovieDetailsDTO;
import com.alkemy.disney.dto.MovieFullDTO;
import com.alkemy.disney.dto.MovieWithoutCharactersDTO;
import com.alkemy.disney.entity.MovieEntity;
import java.util.HashSet;
import java.util.Set;


public final class MovieMapper {
    
    public static MovieEntity toEntity(MovieWithoutCharactersDTO movieWithoutCharactersDTO) {    
        if(movieWithoutCharactersDTO == null) {
            return null;
        }
        
        MovieEntity movieEntity = new MovieEntity();
        
        movieEntity.setId(movieWithoutCharactersDTO.getId());
        movieEntity.setTitle(movieWithoutCharactersDTO.getTitle());
        movieEntity.setImage(movieWithoutCharactersDTO.getImage());
        movieEntity.setRealasedDate(movieWithoutCharactersDTO.getRealasedDate());
        movieEntity.setCalification(movieWithoutCharactersDTO.getCalification());
        movieEntity.setGenre(movieWithoutCharactersDTO.getGenre());
        
        return movieEntity;         
    }
    
    public static MovieEntity toEntity(MovieDetailsDTO movieDetailsDTO) {
        if(movieDetailsDTO == null) {
            return null;
        }
        
        MovieEntity movieEntity = new MovieEntity();
        
        movieEntity.setTitle(movieDetailsDTO.getTitle());
        movieEntity.setImage(movieDetailsDTO.getImage());
        movieEntity.setRealasedDate(movieDetailsDTO.getRealasedDate());
        movieEntity.setCalification(movieDetailsDTO.getCalification());
        movieEntity.setGenre(movieDetailsDTO.getGenre());
        movieEntity.setCharacters(movieDetailsDTO.getCharacters());
        
        return movieEntity;           
    }
    
    public static MovieWithoutCharactersDTO toWithoutCharactersDTO(MovieEntity movieEntity) {
        if(movieEntity == null) {
            return null;
        }
        
        MovieWithoutCharactersDTO movieWithoutCharactersDTO = new MovieWithoutCharactersDTO();
        
        movieWithoutCharactersDTO.setId(movieEntity.getId());
        movieWithoutCharactersDTO.setTitle(movieEntity.getTitle());
        movieWithoutCharactersDTO.setImage(movieEntity.getImage());
        movieWithoutCharactersDTO.setRealasedDate(movieEntity.getRealasedDate());
        movieWithoutCharactersDTO.setCalification(movieEntity.getCalification());
        movieWithoutCharactersDTO.setGenre(movieEntity.getGenre());
        
        return movieWithoutCharactersDTO;
    }
    
    public static MovieFullDTO toFullDTO(MovieEntity movieEntity) {
        if(movieEntity == null) {
            return null;
        }
        
        MovieFullDTO movieFullDTO = new MovieFullDTO();
        
        movieFullDTO.setId(movieEntity.getId());
        movieFullDTO.setTitle(movieEntity.getTitle());
        movieFullDTO.setImage(movieEntity.getImage());
        movieFullDTO.setRealasedDate(movieEntity.getRealasedDate());
        movieFullDTO.setCalification(movieEntity.getCalification());
        movieFullDTO.setGenre(movieEntity.getGenre());
        movieFullDTO.setCharacters(movieEntity.getCharacters());
        
        return movieFullDTO;
        
    }
    
    public static void movieEntityDataUpdate(MovieWithoutCharactersDTO movieWithoutCharactersDTO, MovieEntity movieEntity) throws Exception {
        
        if(movieWithoutCharactersDTO.getId() != movieEntity.getId()) {
            // TODO: A revisar.
            throw new Exception("Error, las entidades son distintas.");
        }
        
        movieEntity.setTitle(movieWithoutCharactersDTO.getTitle());
        movieEntity.setImage(movieWithoutCharactersDTO.getImage());
        movieEntity.setRealasedDate(movieWithoutCharactersDTO.getRealasedDate());
        movieEntity.setCalification(movieWithoutCharactersDTO.getCalification());
        movieEntity.setGenre(movieWithoutCharactersDTO.getGenre());
        
    }
    
    public static MovieDTO toDTO(MovieEntity movieEntity) {
        if(movieEntity == null) return null;
        
        MovieDTO movieDTO = new MovieDTO();
                
        movieDTO.setId(movieEntity.getId());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setImage(movieEntity.getImage());
        movieDTO.setRealasedDate(movieEntity.getRealasedDate());
        
        return movieDTO;
        
    }
    
    public static Set<MovieDTO> toSetDTO(Iterable<MovieEntity> movies) {
        Set<MovieDTO> moviesDTO = new HashSet();
        movies.forEach(movie -> {
            moviesDTO.add(MovieMapper.toDTO(movie));
        });
        return moviesDTO;
    }
    
    
}