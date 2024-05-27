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

    public Set<Film> findByActors(String actorName1, String actorName2) {
        return (Set<Film>) em.createQuery(
                        "SELECT f FROM Film f " +
                                "JOIN AJoue aj1 ON f.id = aj1.film " +
                                "JOIN AJoue aj2 ON f.id = aj2.film " +
                                "JOIN Acteur a1 ON aj1.acteur = a1.idPersonne " +
                                "JOIN Acteur a2 ON aj2.acteur = a2.idPersonne " +
                                "WHERE a1.identite LIKE :identite1 AND a2.identite LIKE :identite2", Film.class)
                .setParameter("identite1", actorName1)
                .setParameter("identite2", actorName2)
                .getResultList();
    }

    public Set<Film> findByPeriod(int startYear, int endYear) {
        return (Set<Film>) em.createQuery(
                        "SELECT f FROM Film f " +
                                "WHERE f.annee BETWEEN :year1 AND :year2", Film.class)
                .setParameter("year1", startYear)
                .setParameter("year2", endYear)
                .getResultList();
    }

    public Set<Film> findByPeriodAndActor(int startYear, int endYear, String actorName) {
        return (Set<Film>) em.createQuery(
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
