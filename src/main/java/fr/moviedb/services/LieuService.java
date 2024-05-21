package fr.moviedb.services;

import fr.moviedb.entities.Langue;
import fr.moviedb.entities.Lieu;
import fr.moviedb.repository.LangueRepository;
import fr.moviedb.repository.LieuRepository;

public class LieuService {

    private  LieuRepository lieuRepository = new LieuRepository();

    public Lieu add(Lieu lieu) {
        Lieu lieuFound = lieuRepository.find(lieu.getId());
        if (lieuFound != null) {
            return lieuFound;
        }
        return lieuRepository.save(lieu);
    }
}
