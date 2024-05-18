package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "realisateur")
public class Realisateur extends Personne {

    @ManyToMany(mappedBy = "realisateurs")
    private Set<Film> films = new HashSet<>();

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}