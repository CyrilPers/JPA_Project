package fr.moviedb.repository;

import fr.moviedb.entities.AJoue;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AJoueRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    /**
     * @param aJoue
     * @return
     */
    public AJoue find(AJoue aJoue) {
        return em.find(AJoue.class, aJoue.getId());
    }

    /**
     * @param id
     * @return
     */
    public AJoue findById(int id) {
        return em.find(AJoue.class, id);
    }

    /**
     * @param aJoue
     * @return
     */
    public AJoue save(AJoue aJoue) {
        transaction.begin();
        em.persist(aJoue);
        transaction.commit();
        return aJoue;
    }

    /**
     * @param acteurId
     * @param idFilm
     * @return
     */
    public AJoue findAjoueByFilmAndActeur(String acteurId, String idFilm) {
        return em.createQuery("SELECT aj FROM AJoue aj " +
                        "WHERE aj.film = :idFilm " +
                        "AND aj.acteur = :idPersonne", AJoue.class)
                .setParameter("idFilm", idFilm)
                .setParameter("idPersonne", acteurId)
                .getSingleResult();
    }
}
