package fr.moviedb;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AJoueId implements Serializable {
    private static final long serialVersionUID = 4214547397137484055L;
    @Column(name = "id_film", nullable = false, length = 50)
    private String idFilm;

    @Column(name = "id_personne", nullable = false, length = 50)
    private String idPersonne;

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AJoueId entity = (AJoueId) o;
        return Objects.equals(this.idFilm, entity.idFilm) &&
                Objects.equals(this.idPersonne, entity.idPersonne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFilm, idPersonne);
    }

}