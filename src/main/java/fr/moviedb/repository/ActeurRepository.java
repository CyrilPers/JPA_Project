package fr.moviedb.repository;

import fr.moviedb.entities.Acteur;
import fr.moviedb.entities.Role;
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
                        "SELECT DISTINCT a FROM Acteur a " +
                                "JOIN a.roles r " +
                                "JOIN r.films f " +
                                "WHERE f.nom LIKE :nom", Acteur.class)
                .setParameter("nom", movieName)
                .getResultList();
    }

    public Set<Acteur> findSameActorsInMovies(String movieName1, String movieName2) {
        return (Set<Acteur>) em.createQuery(
                        "SELECT a FROM Acteur a " +
                                "JOIN a.roles r1 " +
                                "JOIN r1.films f1 " +
                                "JOIN a.roles r2 " +
                                "JOIN r2.films f2 " +
                                "WHERE f1.nom = :movieName1 AND f2.nom = :movieName2", Acteur.class)
                .setParameter("movieName1", movieName1)
                .setParameter("movieName2", movieName2)
                .getResultList();
    }
}
