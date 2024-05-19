package fr.moviedb.services;

import fr.moviedb.entities.Pays;
import fr.moviedb.entities.Ville;
import fr.moviedb.repository.PaysRepository;
import fr.moviedb.repository.VilleRepository;

public class PaysService {

    private PaysRepository paysRepository;

    public PaysService(PaysRepository paysRepository) {
        this.paysRepository = paysRepository;
    }

    public Pays add(String nom) {
        Pays paysFound = paysRepository.findPaysByName(nom);
        if (paysFound != null) {
            return paysFound;
        }
        Pays pays = new Pays(nom);
        return paysRepository.save(pays);
    }
}
