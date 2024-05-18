package fr.moviedb.services;

import fr.moviedb.entities.Ville;
import fr.moviedb.repository.VilleRepository;

public class VilleService {
    private final VilleRepository villeRepository;


    public VilleService(VilleRepository villeRepository) {

        this.villeRepository = villeRepository;
    }

    public Ville save(String nom) {
        return villeRepository.save(nom);
    }
}
