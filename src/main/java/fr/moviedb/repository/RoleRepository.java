package fr.moviedb.repository;

import fr.moviedb.entities.Film;
import fr.moviedb.entities.Role;
import fr.moviedb.utils.ConnectionEntityManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RoleRepository {
    private EntityManager em = ConnectionEntityManager.getEm();
    private EntityTransaction transaction = em.getTransaction();


    public Role save(Role role) {
        transaction.begin();
        em.persist(role);
        transaction.commit();
        return role;
    }

}
