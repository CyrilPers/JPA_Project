package fr.moviedb.services;

import fr.moviedb.entities.Acteur;
import fr.moviedb.repository.ActeurRepository;

import java.util.List;

public class ActeurService {

    private ActeurRepository acteurRepository = new ActeurRepository();

    public Acteur findById(String idActeur) {
        return acteurRepository.findById(idActeur);
    }

    public Acteur add(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public Acteur setRealisateurAsActeur(Acteur acteur) {
        return acteurRepository.setRealisateurAsActeur(acteur);
    }

    public List<Acteur> findByMovie(String movieName) {
        return acteurRepository.findByMovie(movieName);
    }

    public List<Acteur> findSameActorsInMovies(String movieName1, String movieName2) {
        return acteurRepository.findSameActorsInMovies(movieName1, movieName2);
    }

}
