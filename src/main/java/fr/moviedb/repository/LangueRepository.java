package fr.moviedb.repository;

import fr.moviedb.entities.Langue;

import fr.moviedb.utils.ConnectionEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LangueRepository {
    private EntityManager em = ConnectionEntityManager.getEm();
    private EntityTransaction transaction = em.getTransaction();

    public Langue findLangueByName(String libelle) {
        return em.createQuery("SELECT l FROM Langue l WHERE l.libelle = :libelle", Langue.class)
                .setParameter("libelle", libelle)
                .getSingleResult();
    }

    public Langue save(Langue langue) {
        transaction.begin();
        em.persist(langue);
        transaction.commit();
        return langue;
    }
}
