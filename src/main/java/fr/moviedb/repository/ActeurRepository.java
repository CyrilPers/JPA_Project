package fr.moviedb.repository;
import fr.moviedb.entities.Acteur;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ActeurRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    /**
     * @param acteur
     * @return
     */
    public Acteur find(Acteur acteur) {
        return em.find(Acteur.class, acteur.getIdPersonne());
    }

    /**
     * @param id
     * @return
     */
    public Acteur findById(String id) {
        return em.find(Acteur.class, id);
    }

    /**
     * @param acteur
     * @return
     */
    public Acteur save(Acteur acteur) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(acteur);
        transaction.commit();
        return acteur;
    }
}
