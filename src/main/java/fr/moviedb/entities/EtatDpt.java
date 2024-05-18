package fr.moviedb.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "etat_dpt")
public class EtatDpt {
    @Id
    @Column(name = "etat_dpt", nullable = false, length = 50)
    private String nom;

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

}