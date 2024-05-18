package fr.moviedb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "a_joue")
public class AJoue {
    @EmbeddedId
    private AJoueId id;

    @MapsId("idFilm")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_film", nullable = false)
    private Film film;

    @MapsId("idPersonne")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personne", nullable = false)
    private Acteur acteur;

    @Column(name = "personnage", length = 50)
    private String personnage;

    public AJoue(Acteur acteur, Film film) {
        this.acteur = acteur;
        this.film = film;
    }

    public AJoue() {

    }

    public AJoueId getId() {
        return id;
    }

    public void setId(AJoueId id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

}