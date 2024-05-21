package fr.moviedb.services;
import fr.moviedb.entities.Lieu;
import fr.moviedb.repository.LieuRepository;

public class LieuService {

    private  LieuRepository lieuRepository = new LieuRepository();

    public Lieu add(Lieu lieu) {
        // TODO check lieu exist
        return lieuRepository.save(lieu);
    }
}
