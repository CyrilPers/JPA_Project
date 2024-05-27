package fr.moviedb.services;
import fr.moviedb.entities.Realisateur;
import fr.moviedb.repository.RealisateurRepository;

public class RealisateurService {

    private RealisateurRepository realisateurRepository = new RealisateurRepository();

    public Realisateur findById(String idRealisateur) {
        try {
            return realisateurRepository.findById(idRealisateur);
        } catch (Exception e) {
            return null;
        }
    }

    public Realisateur add(Realisateur realissateur) {
        return realisateurRepository.save(realissateur);
    }

    public Realisateur setActeurAsRealisateur(Realisateur realisateur) {
        return realisateurRepository.saveActeurAsRealisateur(realisateur);
    }
}
