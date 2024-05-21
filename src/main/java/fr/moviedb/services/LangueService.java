package fr.moviedb.services;

import fr.moviedb.entities.Langue;
import fr.moviedb.entities.Ville;
import fr.moviedb.repository.LangueRepository;
import fr.moviedb.repository.VilleRepository;

public class LangueService {
    private LangueRepository langueRepository = new LangueRepository();


    public Langue add(String nom) {
        try {
            return langueRepository.findLangueByName(nom);
        } catch (Exception e) {
            Langue langue = new Langue(nom);
            return langueRepository.save(langue);
        }
    }
}
