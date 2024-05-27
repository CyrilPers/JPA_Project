package fr.moviedb.services;

import fr.moviedb.entities.Film;
import fr.moviedb.repository.FilmRepository;

import java.util.List;

public class FilmService {

    private FilmRepository filmRepository = new FilmRepository();

    public Film add(Film film) {
        return filmRepository.save(film);
    }

    public Film find(String id) {
        Film filmFound = filmRepository.findById(id);
        if (filmFound == null) {
           return null;
        }
        return filmFound;
    }

    public List<Film> findByActors(String actorName1, String actorName2) {
        return filmRepository.findByActors(actorName1, actorName2);
    }

    public List<Film> findByPeriod(int startYear, int endYear) {
        return (List<Film>) filmRepository.findByPeriod(startYear, endYear);
    }

    public List<Film> findByPeriodAndActors(int startYear, int endYear, String actorName) {
        return filmRepository.findByPeriodAndActor(startYear, endYear, actorName);
    }

    public List<Film> findByActor(String actorName) {
        return filmRepository.findByActor(actorName);
    }
    }
