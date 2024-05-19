package fr.moviedb.repository;

import fr.moviedb.entities.Realisateur;
import fr.moviedb.entities.Ville;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RealisateurRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Realisateur find(Realisateur realisateur) {
        return em.find(Realisateur.class, realisateur.getIdPersonne());
    }

    public Realisateur findById(String id) {
        return em.find(Realisateur.class, id);
    }

    public Realisateur save(Realisateur realisateur) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(realisateur);
        transaction.commit();
        return realisateur;
    }
}
