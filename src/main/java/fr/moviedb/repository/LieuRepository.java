package fr.moviedb.repository;

import fr.moviedb.entities.Lieu;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LieuRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Lieu find(Lieu lieu) {
        return em.find(Lieu.class, lieu.getId());
    }

    public Lieu findById(int id) {
        return em.find(Lieu.class, id);
    }

    public Lieu save(Lieu lieu) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(lieu);
        transaction.commit();
        return lieu;
    }
}
