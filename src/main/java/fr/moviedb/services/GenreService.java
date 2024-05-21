package fr.moviedb.services;

import fr.moviedb.entities.Genre;
import fr.moviedb.repository.GenreRepository;
import jakarta.persistence.EntityTransaction;

public class GenreService {

    private  GenreRepository genreRepository = new GenreRepository();


    public Genre add(String nom) {
        try {
            return genreRepository.findGenreByName(nom);
        } catch (Exception e) {
            Genre newGenre = new Genre(nom);
            return genreRepository.save(newGenre);
        }
    }
}
