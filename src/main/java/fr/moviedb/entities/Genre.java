package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @Column(name = "id_genre", nullable = false, length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idGenre;

    @Column(name = "libelle", length = 50)
    private String libelle;

    public Genre(String libelle) {
        this.libelle = libelle;
    }

    @ManyToMany(mappedBy = "genres")
    private Set<Film> films = new HashSet<>();

    public String getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(String idGenre) {
        this.idGenre = idGenre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}