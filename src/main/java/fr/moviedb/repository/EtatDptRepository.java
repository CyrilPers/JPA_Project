package fr.moviedb.repository;

import fr.moviedb.entities.EtatDpt;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EtatDptRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public EtatDpt findEtatDptByName(String nom) {
        return em.find(EtatDpt.class, nom);
    }

    public EtatDpt save(EtatDpt etatDpt) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(etatDpt);
        transaction.commit();
        return etatDpt;
    }

}
