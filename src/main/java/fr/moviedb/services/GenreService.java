package fr.moviedb.services;

import fr.moviedb.entities.Genre;
import fr.moviedb.repository.GenreRepository;
import jakarta.persistence.EntityTransaction;

public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre add(String nom) {
        Genre genreFound = genreRepository.findGenreByName(nom);
        if (genreFound != null) {
            return genreFound;
        }
        Genre genre = new Genre(nom);
        return genreRepository.save(genre);
    }
}
