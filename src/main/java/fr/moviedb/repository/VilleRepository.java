package fr.moviedb.repository;

import fr.moviedb.entities.Ville;
import fr.moviedb.utils.ConnectionEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VilleRepository {
    private EntityManager em = ConnectionEntityManager.getEm();
    private EntityTransaction transaction = em.getTransaction();

    public Ville findVilleByName(String nom) {
        return em.find(Ville.class, nom);
    }

    public Ville save(Ville ville) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ville);
        transaction.commit();
        return ville;
    }
}