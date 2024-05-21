package fr.moviedb.repository;

import fr.moviedb.entities.Ville;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class VilleRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Ville findVilleByName(String nom) {
        System.out.println(nom);
        return em.find(Ville.class, nom);
    }

    public Ville save(Ville ville) {
        System.out.println(ville.toString());
        transaction.begin();
        em.persist(ville);
        transaction.commit();
        return ville;
    }
}