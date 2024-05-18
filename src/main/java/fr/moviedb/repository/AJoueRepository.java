package fr.moviedb.repository;

import fr.moviedb.entities.AJoue;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class AJoueRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public AJoue find(AJoue aJoue) {
        return em.find(AJoue.class, aJoue.getId());
    }

    public AJoue findById(int id) {
        return em.find(AJoue.class, id);
    }

    public AJoue save(AJoue aJoue) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(aJoue);
        transaction.commit();
        return aJoue;
    }

    public AJoue findAjoueByFilmAndActeur(String acteurId, String idFilm) {
        return em.createQuery("SELECT aj FROM AJoue aj WHERE aj.id_film = :idFilm AND aj.id_personne = :idPersonne", AJoue.class)
                .setParameter("idFilm", idFilm)
                .setParameter("idPersonne", acteurId)
                .getSingleResult();
    }
}
