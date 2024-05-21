package fr.moviedb.repository;

import fr.moviedb.entities.Acteur;
import fr.moviedb.utils.ConnectionEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Set;

public class ActeurRepository {
    private EntityManager em = ConnectionEntityManager.getEm();
    private EntityTransaction transaction = em.getTransaction();

    /**
     * @param id
     * @return
     */
    public Acteur findById(String id) {
        return em.find(Acteur.class, id);
    }

    /**
     * @param acteur
     * @return
     */
    public Acteur save(Acteur acteur) {
        transaction.begin();
        em.persist(acteur);
        transaction.commit();
        return acteur;
    }

    /**
     * @param movieName
     * @return
     */
    public Set<Acteur> findByMovie(String movieName) {
        return (Set<Acteur>) em.createQuery(
                        "SELECT a FROM Acteur a " +
                                "JOIN AJoue aj ON aj.acteur = a.idPersonne " +
                                "JOIN Film f ON f.idFilm = aj.film " +
                                "WHERE f.nom LIKE :nom", Acteur.class)
                .setParameter("nom", movieName)
                .getResultList();
    }

    public Set<Acteur> findSameActorsInMovies(String movieName1, String movieName2) {
        return (Set<Acteur>) em.createQuery(
                        "SELECT a FROM Acteur a " +
                                "JOIN AJoue aj ON aj.acteur = a.idPersonne " +
                                "JOIN Film f1 ON aj.film = f1.idFilm " +
                                "JOIN AJoue aj2 ON aj2.acteur = a.idPersonne " +
                                "JOIN Film f2 ON aj2.film = f2.idFilm " +
                                "WHERE f1.nom LIKE :movieName1 AND f2.nom LIKE :movieName2", Acteur.class)
                .setParameter("movieName1", movieName1)
                .setParameter("movieName2", movieName2)
                .getResultList();
    }
}
