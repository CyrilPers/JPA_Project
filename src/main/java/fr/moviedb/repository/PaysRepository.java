package fr.moviedb.repository;

import fr.moviedb.entities.Pays;
import fr.moviedb.entities.Ville;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PaysRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public PaysRepository(EntityManager em) {
        this.em = em;
    }

    public Pays findPaysByName(String nom) {
        return em.find(Pays.class, nom);
    }

    public Pays save(Pays pays) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pays);
        transaction.commit();
        return pays;
    }
}
