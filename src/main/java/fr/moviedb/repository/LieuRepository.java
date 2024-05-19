package fr.moviedb.repository;

import fr.moviedb.entities.Lieu;
import fr.moviedb.entities.LieuId;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LieuRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Lieu find(LieuId lieuid) {
        return em.find(Lieu.class, lieuid);
    }

    public Lieu findById(int id) {
        return em.find(Lieu.class, id);
    }

    public Lieu save(Lieu lieu) {
        transaction.begin();
        em.persist(lieu);
        transaction.commit();
        return lieu;
    }
}
