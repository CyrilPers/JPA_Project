package fr.moviedb.repository;

import fr.moviedb.entities.Film;
import fr.moviedb.utils.ConnectionEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilmRepository {

    private EntityManager em = ConnectionEntityManager.getEm();
    private EntityTransaction transaction = em.getTransaction();


    public Film save(Film film) {
        transaction.begin();
        em.persist(film);
        transaction.commit();
        return film;
    }

    public Film findById(String id) {
        return em.find(Film.class, id);
    }

    public List<Film> findByActors(String actorName1, String actorName2) {
        return em.createQuery(
                        "SELECT DISTINCT f FROM Film f " +
                                "JOIN f.roles r1 " +
                                "JOIN f.roles r2 " +
                                "JOIN r1.acteurs a1 " +
                                "JOIN r2.acteurs a2 " +
                                "WHERE a1.identite LIKE :identite1 AND a2.identite LIKE :identite2", Film.class)
                .setParameter("identite1", "%" + actorName1 + "%")
                .setParameter("identite2", "%" + actorName2 + "%")
                .getResultList();
    }

    public List<Film> findByPeriod(int startYear, int endYear) {
        return (List<Film>) em.createQuery(
                        "SELECT f FROM Film f " +
                                "WHERE f.annee BETWEEN :year1 AND :year2", Film.class)
                .setParameter("year1", startYear)
                .setParameter("year2", endYear)
                .getResultList();
    }

    public List<Film> findByPeriodAndActor(int startYear, int endYear, String actorName) {
        return (List<Film>) em.createQuery(
                        "SELECT f FROM Film f " +
                                "JOIN f.roles r " +
                                "JOIN r.acteurs a " +
                                "WHERE a.identite LIKE :identite AND f.annee BETWEEN :year1 AND :year2", Film.class)
                .setParameter("year1", startYear)
                .setParameter("year2", endYear)
                .setParameter("identite", actorName)

                .getResultList();
    }

    public List<Film> findByActor(String actorName) {
        return (List<Film>) em.createQuery(
                        "SELECT f FROM Film f " +
                                "JOIN f.roles r " +
                                "JOIN r.acteurs a " +
                                "WHERE a.identite LIKE :identite", Film.class)
                .setParameter("identite", "%" + actorName + "%")
                .getResultList();

    }
}
