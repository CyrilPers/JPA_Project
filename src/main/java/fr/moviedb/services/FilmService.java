package fr.moviedb.services;

import fr.moviedb.entities.Film;
import fr.moviedb.repository.FilmRepository;

import java.util.Set;

public class FilmService {

    private final FilmRepository filmRepository;


    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film add(Film film) {
        return filmRepository.save(film);
    }

    public Set<Film> findByActors(String actorName1, String actorName2) {
        return filmRepository.findByActors(actorName1, actorName2);
    }
}
