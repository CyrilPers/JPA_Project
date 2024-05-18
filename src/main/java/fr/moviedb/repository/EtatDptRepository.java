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

    public EtatDpt save(String nom) {
        EtatDpt etatDptFound = findEtatDptByName(nom);
        if (etatDptFound != null) {
            return etatDptFound;
        }
        EtatDpt etatDpt = new EtatDpt(nom);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(etatDpt);
        transaction.commit();
        return etatDpt;
    }

}
