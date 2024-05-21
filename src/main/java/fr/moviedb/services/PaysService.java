package fr.moviedb.services;

import fr.moviedb.entities.Pays;
import fr.moviedb.repository.PaysRepository;

public class PaysService {

    private PaysRepository paysRepository = new PaysRepository();

    public Pays add(String nom) {
        try {
            return paysRepository.findPaysByName(nom);
        } catch (Exception e) {
            Pays pays = new Pays(nom);
            System.out.println("save");
            System.out.println("nom");
            return paysRepository.save(pays);
        }
    }
}
