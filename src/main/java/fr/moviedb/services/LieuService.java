package fr.moviedb.services;

import fr.moviedb.entities.Langue;
import fr.moviedb.entities.Lieu;
import fr.moviedb.repository.LangueRepository;
import fr.moviedb.repository.LieuRepository;

public class LieuService {

    private final LieuRepository lieuRepository;

    public LieuService(LieuRepository lieuRepository) {
        this.lieuRepository = lieuRepository;
    }

    public Lieu add(Lieu lieu) {
        return lieuRepository.save(lieu);
    }
}
