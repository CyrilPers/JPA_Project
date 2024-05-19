package fr.moviedb.services;

import fr.moviedb.entities.Acteur;
import fr.moviedb.repository.ActeurRepository;

public class ActeurService {

    private ActeurRepository acteurRepository;

    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = acteurRepository;
    }

    public Acteur findById(String idActeur) {
        return acteurRepository.findById(idActeur);
    }

    public Acteur add(Acteur acteur) {
        return acteurRepository.save(acteur);
    }
}
