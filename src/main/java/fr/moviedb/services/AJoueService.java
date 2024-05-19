package fr.moviedb.services;

import fr.moviedb.entities.AJoue;
import fr.moviedb.entities.Pays;
import fr.moviedb.repository.AJoueRepository;
import fr.moviedb.repository.PaysRepository;

public class AJoueService {

    private AJoueRepository aJoueRepository;


    public AJoue add(AJoue aJoue) {
        return aJoueRepository.save(aJoue);
    }

    public AJoue findAjoueByFilmAndActeur(String acteurId, String idFilm) {
        return aJoueRepository.findAjoueByFilmAndActeur(acteurId, idFilm);
    }
}

