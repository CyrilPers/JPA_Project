package fr.moviedb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pays")
public class Pays {
    @Id
    @Column(name = "pays", nullable = false, length = 50)
    private String nom;

    public Pays(String nom) {
    }

    public Pays() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}