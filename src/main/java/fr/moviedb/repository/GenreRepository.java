package fr.moviedb.repository;

import fr.moviedb.entities.Genre;
import fr.moviedb.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class GenreRepository {
    private EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
    private EntityTransaction transaction = em.getTransaction();

    public Genre findGenreByName(String libelle) {
        return em.createQuery("SELECT g FROM Genre g WHERE g.libelle = :libelle", Genre.class)
                .setParameter("libelle", libelle)
                .getSingleResult();
    }

    public Genre save(Genre genre) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(genre);
        transaction.commit();
        return genre;
    }
}
