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


    public Pays save(String nom) {
        Pays paysFound = findPaysByName(nom);
        if (paysFound != null) {
            return paysFound;
        }
        Pays pays = new Pays(nom);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pays);
        transaction.commit();
        return pays;
    }
}
