package fr.moviedb.services;

import fr.moviedb.entities.Langue;
import fr.moviedb.entities.Ville;
import fr.moviedb.repository.LangueRepository;
import fr.moviedb.repository.VilleRepository;

public class LangueService {
    private LangueRepository langueRepository;


    public Langue add(String nom) {
        Langue langueFound = langueRepository.findLangueByName(nom);
        if (langueFound != null) {
            return langueFound;
        }
        Langue langue = new Langue(nom);
        return langueRepository.save(langue);
    }

}
