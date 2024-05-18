package fr.moviedb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ville")
public class Ville {
    @Id
    @Column(name = "ville", nullable = false, length = 50)
    private String nom;

    public Ville(String ville) {
        this.nom = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}