package fr.moviedb.repository;

import fr.moviedb.entities.Film;
import fr.moviedb.entities.Langue;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Set;

public class FilmRepository {

    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();


    public Film save(Film film) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(film);
        transaction.commit();
        return film;
    }

    public Set<Film> findByActors(String actorName1, String actorName2) {
        return (Set<Film>) em.createQuery(
                        "SELECT f FROM Film f " +
                                "JOIN a_joue aj1 ON f.id = aj1.id_film " +
                                "JOIN a_joue aj2 ON f.id = aj2.id_film " +
                                "JOIN Acteur a1 ON aj1.id_personne = a1.id_personne " +
                                "JOIN Acteur a2 ON aj2.id_personne = a2.id_personne " +
                                "WHERE a1.identite LIKE :identite1 AND a2.identite LIKE :identite2")
                .setParameter("identite1", actorName1)
                .setParameter("identite2", actorName2)
                .getResultList();
    }
}