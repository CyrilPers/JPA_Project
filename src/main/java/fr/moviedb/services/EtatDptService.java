package fr.moviedb.services;

import fr.moviedb.entities.EtatDpt;
import fr.moviedb.entities.Ville;
import fr.moviedb.repository.EtatDptRepository;
import fr.moviedb.repository.VilleRepository;

public class EtatDptService {

    private final EtatDptRepository etatDptRepository;


    public EtatDptService(EtatDptRepository etatDptRepository) {
        this.etatDptRepository = etatDptRepository;
    }

    public EtatDpt add(String nom) {
        EtatDpt etatDptFound = etatDptRepository.findEtatDptByName(nom);
        if (etatDptFound != null) {
            return etatDptFound;
        }
        EtatDpt etatDpt = new EtatDpt(nom);
        return etatDptRepository.save(etatDpt);
    }
}
