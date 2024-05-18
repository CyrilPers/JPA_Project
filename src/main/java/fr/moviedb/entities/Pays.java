package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "pays")
public class Pay {
    @Id
    @Column(name = "code_insee", nullable = false, length = 50)
    private String codeInsee;

    @Column(name = "libelle", length = 50)
    private String libelle;

    @OneToMany(mappedBy = "codeInsee2")
    private Set<Lieu> lieus = new LinkedHashSet<>();

    public String getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(String codeInsee) {
        this.codeInsee = codeInsee;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Lieu> getLieus() {
        return lieus;
    }

    public void setLieus(Set<Lieu> lieus) {
        this.lieus = lieus;
    }

}