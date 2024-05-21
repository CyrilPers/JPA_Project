package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "etat_dpt")
public class EtatDpt {
    @Id
    @Column(name = "etat_dpt", nullable = false, length = 50)
    private String nom;

    @OneToMany(mappedBy = "etatDpt")
    private Set<Lieu> lieus = new HashSet<>();


    public EtatDpt(String etatDpt) {
        this.nom = etatDpt;
    }

    public EtatDpt() {

    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }

    public Set<Lieu> getLieus() {
        return lieus;
    }

    public void setLieus(Set<Lieu> lieus) {
        this.lieus = lieus;
    }

}