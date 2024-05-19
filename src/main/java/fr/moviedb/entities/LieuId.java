package fr.moviedb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LieuId implements Serializable {
    private static final long serialVersionUID = -2864949909950877520L;
    @Column(name = "ville", nullable = false, length = 50)
    private String ville;

    @Column(name = "etat_dpt", nullable = false, length = 50)
    private String etatDpt;

    @Column(name = "pays", nullable = false, length = 50)
    private String pays;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEtatDpt() {
        return etatDpt;
    }

    public void setEtatDpt(String etatDpt) {
        this.etatDpt = etatDpt;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LieuId entity = (LieuId) o;
        return Objects.equals(this.ville, entity.ville) &&
                Objects.equals(this.etatDpt, entity.etatDpt) &&
                Objects.equals(this.pays, entity.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ville, etatDpt, pays);
    }
}