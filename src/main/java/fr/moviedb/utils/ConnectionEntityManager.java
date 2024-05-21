package fr.moviedb.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ConnectionEntityManager {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static EntityManagerFactory getEmf() {
        if (emf !=null)
            return emf;
        return Persistence.createEntityManagerFactory("movie_db");
        }


    public static EntityManager getEm() {
        if (em != null)
            return em;
        return getEmf().createEntityManager();
    }


    public static void closeEM() {
        em.close();
    }
}
