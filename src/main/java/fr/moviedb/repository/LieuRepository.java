package fr.moviedb.repository;

import fr.moviedb.entities.Lieu;
import fr.moviedb.utils.ConnectionEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LieuRepository {
    private EntityManager em = ConnectionEntityManager.getEm();
    private EntityTransaction transaction = em.getTransaction();

    public Lieu find(Integer id) {
        return em.find(Lieu.class, id);
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
