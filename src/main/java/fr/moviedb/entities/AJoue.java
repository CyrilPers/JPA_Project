package fr.moviedb;

import jakarta.persistence.*;

@Entity
@Table(name = "a_joue")
public class AJoue {
    @EmbeddedId
    private AJoueId id;

    @MapsId("idFilm")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_film", nullable = false)
    private Film idFilm;

    @MapsId("idPersonne")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personne", nullable = false)
    private Acteur idPersonne;

    @Column(name = "personnage", length = 50)
    private String personnage;

    @Column(name = "castingPrincipal", nullable = false)
    private Boolean castingPrincipal = false;

    public AJoueId getId() {
        return id;
    }

    public void setId(AJoueId id) {
        this.id = id;
    }

    public Film getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Film idFilm) {
        this.idFilm = idFilm;
    }

    public Acteur getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Acteur idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

    public Boolean getCastingPrincipal() {
        return castingPrincipal;
    }

    public void setCastingPrincipal(Boolean castingPrincipal) {
        this.castingPrincipal = castingPrincipal;
    }

}