package fr.moviedb.services;

import fr.moviedb.entities.Ville;
import fr.moviedb.repository.VilleRepository;

public class VilleService {
    private final VilleRepository villeRepository;


    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public Ville add(String nom) {
        Ville villeFound = villeRepository.findVilleByName(nom);
        if (villeFound != null) {
            return villeFound;
        }
        Ville ville = new Ville(nom);
        return villeRepository.save(ville);
    }
}
