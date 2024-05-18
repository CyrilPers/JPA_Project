package fr.moviedb.repository;
import fr.moviedb.entities.Acteur;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ActeurRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Acteur find(Acteur acteur) {
        return em.find(Acteur.class, acteur.getIdPersonne());
    }

    public Acteur findById(int id) {
        return em.find(Acteur.class, id);
    }

    public Acteur save(Acteur acteur) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(acteur);
        transaction.commit();
        return acteur;
    }
}
