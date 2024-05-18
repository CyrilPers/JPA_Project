package fr.moviedb.repository;

import fr.moviedb.entities.Genre;
import fr.moviedb.entities.Langue;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LangueRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Langue findLangueByName(String libelle) {
        return em.createQuery("SELECT l FROM Langue l WHERE l.libelle = :libelle", Langue.class)
                .setParameter("libelle", libelle)
                .getSingleResult();
    }

    public Langue save(String libelle) {
        Langue langueFound = findLangueByName(libelle);
        if (langueFound != null) {
            return langueFound;
        }
        Langue langue = new Langue(libelle);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(langue);
        transaction.commit();
        return langue;
    }
}
