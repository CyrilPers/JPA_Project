package fr.moviedb.repository;

import fr.moviedb.entities.Ville;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public abstract class VilleRepository {
   private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Ville findVilleByName(String nom) {
        return em.find(Ville.class, nom);
    }

    public Ville save(String nom) {
        Ville villeFound = findVilleByName(nom);
        if (villeFound != null) {
            return villeFound;
        }
        Ville ville = new Ville(nom);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(nom);
        transaction.commit();
        return ville;
    }
}