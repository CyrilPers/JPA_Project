package fr.moviedb.services;

import fr.moviedb.entities.Acteur;
import fr.moviedb.repository.ActeurRepository;

import java.util.Set;

public class ActeurService {

    private ActeurRepository acteurRepository;

    public Acteur findById(String idActeur) {
        return acteurRepository.findById(idActeur);
    }

    public Acteur add(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public Set<Acteur> findByMovie(String movieName) {
        return acteurRepository.findByMovie(movieName);
    }


}
