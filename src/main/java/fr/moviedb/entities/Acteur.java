package fr.moviedb.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Acteur extends Personne{

    @Column(name = "taille", precision = 4, scale = 2)
    private BigDecimal taille;

    @OneToMany(mappedBy = "acteur")
    private Set<AJoue> aJoues = new HashSet<>();

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

    @Override
    public String toString() {
        return "Acteur : [ identité : " + getIdentite() + " taille " + taille +" ]";
    }

}