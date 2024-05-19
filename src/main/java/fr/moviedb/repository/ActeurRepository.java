package fr.moviedb.repository;
import fr.moviedb.entities.Acteur;
import fr.moviedb.entities.Film;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Set;

public class ActeurRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
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
}
