package fr.moviedb;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "acteur")
public class Acteur extends Personne{

    @Column(name = "taille", precision = 4, scale = 2)
    private BigDecimal taille;

    @OneToMany(mappedBy = "idPersonne")
    private Set<AJoue> aJoues = new LinkedHashSet<>();

    public BigDecimal getTaille() {
        return taille;
    }

    public void setTaille(BigDecimal taille) {
        this.taille = taille;
    }

    public Set<AJoue> getAJoues() {
        return aJoues;
    }

    public void setAJoues(Set<AJoue> aJoues) {
        this.aJoues = aJoues;
    }

}