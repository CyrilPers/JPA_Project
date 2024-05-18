package fr.moviedb;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @Column(name = "id_film", nullable = false, length = 50)
    private String idFilm;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "`année`")
    private Integer année;

    @Column(name = "rating", precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(name = "url", length = 50)
    private String url;

    @Column(name = "resume", length = 250)
    private String resume;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_personne", nullable = false)
    private Realisateur idPersonne;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_lieu", nullable = false)
    private Lieu idLieu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_langue", nullable = false)
    private Langue idLangue;

    @OneToMany(mappedBy = "idFilm")
    private Set<AJoue> aJoues = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "idFilm")
    private Set<Genre> genres = new LinkedHashSet<>();

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getAnnée() {
        return année;
    }

    public void setAnnée(Integer année) {
        this.année = année;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Realisateur getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Realisateur idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Lieu getIdLieu() {
        return idLieu;
    }

    public void setIdLieu(Lieu idLieu) {
        this.idLieu = idLieu;
    }

    public Langue getIdLangue() {
        return idLangue;
    }

    public void setIdLangue(Langue idLangue) {
        this.idLangue = idLangue;
    }

    public Set<AJoue> getAJoues() {
        return aJoues;
    }

    public void setAJoues(Set<AJoue> aJoues) {
        this.aJoues = aJoues;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

}