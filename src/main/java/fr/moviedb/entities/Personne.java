package fr.moviedb;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "personne")
public abstract class Personne {
    @Id
    @Column(name = "id_personne", nullable = false, length = 50)
    private String idPersonne;

    @Column(name = "identite", length = 50)
    private String identite;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "taille", precision = 4, scale = 2)
    private BigDecimal taille;

    @Column(name = "url", length = 50)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lieu", nullable = false)
    private Lieu idLieu;

    @OneToOne(mappedBy = "idPersonne")
    private Acteur acteur;

    @OneToOne(mappedBy = "idPersonne")
    private Realisateur realisateur;

    public String getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(String idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public BigDecimal getTaille() {
        return taille;
    }

    public void setTaille(BigDecimal taille) {
        this.taille = taille;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Lieu getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(Lieu idLieu) {
        this.idLieu = idLieu;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

}