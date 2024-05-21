package fr.moviedb.services;

import fr.moviedb.entities.Realisateur;
import fr.moviedb.repository.RealisateurRepository;

public class RealisateurService {

    private RealisateurRepository realisateurRepository = new RealisateurRepository();

    public Realisateur findById(String idRealisateur) {
        return realisateurRepository.findById(idRealisateur);
    }

    public Realisateur add(Realisateur realissateur) {
        return realisateurRepository.save(realissateur);
    }
}
