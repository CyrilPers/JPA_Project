package fr.moviedb.services;

import fr.moviedb.entities.Acteur;
import fr.moviedb.entities.Realisateur;
import fr.moviedb.repository.ActeurRepository;
import fr.moviedb.repository.RealisateurRepository;

public class RealisateurService {
    private RealisateurRepository realisateurRepository;

    public RealisateurService(RealisateurRepository realisateurRepository) {
        this.realisateurRepository = realisateurRepository;
    }

    public Realisateur findById(String idRealisateur) {
        return realisateurRepository.findById(idRealisateur);
    }

    public Realisateur add(Realisateur realissateur) {
        return realisateurRepository.save(realissateur);
    }
}
