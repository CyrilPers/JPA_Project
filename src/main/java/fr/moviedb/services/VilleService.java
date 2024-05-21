package fr.moviedb.services;

import fr.moviedb.entities.Ville;
import fr.moviedb.repository.VilleRepository;

public class VilleService {

    private VilleRepository villeRepository = new VilleRepository();

    public Ville add(String nom) {
        try {
            return villeRepository.findVilleByName(nom);
        } catch (Exception e) {
            Ville ville = new Ville(nom);
            return villeRepository.save(ville);
        }
    }
}
