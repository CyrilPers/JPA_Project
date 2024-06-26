package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name="realisateur")
public class Realisateur extends Personne {

    @ManyToMany
    @JoinTable(name = "a_realise",
            joinColumns = @JoinColumn(name = "id_personne"),
            inverseJoinColumns = @JoinColumn(name = "id_film"))
    private Set<Film> films = new HashSet<>();

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Realisateur : [ identité : " + getIdentite() + " ]";
    }
}