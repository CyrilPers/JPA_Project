package fr.moviedb.services;

import fr.moviedb.entities.EtatDpt;
import fr.moviedb.entities.Ville;
import fr.moviedb.repository.EtatDptRepository;
import fr.moviedb.repository.VilleRepository;

public class EtatDptService {

    private EtatDptRepository etatDptRepository = new EtatDptRepository();


    public EtatDpt add(String nom) {
        try {
            return etatDptRepository.findEtatDptByName(nom);
        } catch (Exception e) {
            EtatDpt etatDpt = new EtatDpt(nom);
            return etatDptRepository.save(etatDpt);
        }
    }
}
