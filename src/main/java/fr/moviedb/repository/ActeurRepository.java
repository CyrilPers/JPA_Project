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

    public Set<Acteur> findByMovie(String movieName) {
        return (Set<Acteur>) em.createQuery(
                        "SELECT a FROM Acteur a " +
                                "JOIN a_joue aj ON a.id = aj.id_personne " +
                                "JOIN Film f ON aj1.id_film = a1.id_personne " +
                                "WHERE f.nom LIKE :nom")
                .setParameter("nom", movieName)
                .getResultList();
    }




}
