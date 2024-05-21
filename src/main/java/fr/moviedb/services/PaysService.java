package fr.moviedb.services;

import fr.moviedb.entities.Pays;
import fr.moviedb.repository.PaysRepository;

public class PaysService {

    private PaysRepository paysRepository = new PaysRepository();

    public Pays add(String nom) {
        Pays paysFound = paysRepository.findPaysByName(nom);
        if (paysFound != null) {
            return paysFound;
        }
        Pays pays = new Pays(nom);
        return paysRepository.save(pays);
    }
}
