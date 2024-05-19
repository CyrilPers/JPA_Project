package fr.moviedb.services;

import fr.moviedb.entities.AJoue;
import fr.moviedb.entities.Pays;
import fr.moviedb.repository.AJoueRepository;
import fr.moviedb.repository.PaysRepository;

public class AJoueService {

    private AJoueRepository aJoueRepository;

    public AJoueService(AJoueRepository aJoueRepository) {
        this.aJoueRepository = aJoueRepository;
    }

    public AJoue findAjoueByFilmAndActeur(String film, String acteur) {
        return aJoueRepository.findAjoueByFilmAndActeur(film, acteur);
    }

    public AJoue add(AJoue aJoue) {
        return aJoueRepository.save(aJoue);
    }
}
