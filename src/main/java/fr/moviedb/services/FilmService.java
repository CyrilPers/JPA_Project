package fr.moviedb.services;

import fr.moviedb.entities.Film;
import fr.moviedb.repository.FilmRepository;

import java.util.Set;

public class FilmService {

    private FilmRepository filmRepository;

    public Film add(Film film) {
        return filmRepository.save(film);
    }

    public Set<Film> findByActors(String actorName1, String actorName2) {
        return filmRepository.findByActors(actorName1, actorName2);
    }

    public Set<Film> findByPeriod(int startYear, int endYear) {
        return filmRepository.findByPeriod(startYear, endYear);
    }

    public Set<Film> findByPeriodAndActors(int startYear, int endYear, String actorName) {
        return filmRepository.findByPeriodAndActor(startYear, endYear, actorName);
    }

    public Set<Film> findByActor(String actorName) {
        return filmRepository.findByActor(actorName);
    }


}
