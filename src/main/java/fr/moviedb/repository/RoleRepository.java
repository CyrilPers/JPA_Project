package fr.moviedb.repository;

import fr.moviedb.entities.*;
import fr.moviedb.utils.ConnectionEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.Set;

public class RoleRepository {
    private EntityManager em = ConnectionEntityManager.getEm();
    private EntityTransaction transaction = em.getTransaction();


    public Role save(Role role) {
        transaction.begin();
        em.persist(role);
        transaction.commit();
        return role;
    }

    public Role findRoleWithoutPersonnage(Film film, Acteur acteur) {
        try {
            return em.createQuery("SELECT r FROM Role r " +
                            "JOIN r.films f " +
                            "JOIN r.acteurs a " +
                            "WHERE f.idFilm = :idFilm " +
                            "AND a.idPersonne = :idActeur " +
                            "AND r.personnage IS NULL", Role.class)
                    .setParameter("idActeur", acteur.getIdPersonne())
                    .setParameter("idFilm", film.getIdFilm())
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }


    public Role find(Role role) {
       try {
           return em.find(Role.class, role.getId());
       } catch (Exception e) {
           return null;
       }
    }
}
