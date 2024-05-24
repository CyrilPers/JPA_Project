package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "id_role", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "personnage", length = 50)
    private String personnage;

    @ManyToMany(mappedBy = "roles")
    private Set<Film> films = new HashSet<>();

    @ManyToMany(mappedBy = "roles")
    private Set<Acteur> acteurs = new HashSet<>();

    public Role() {
    }

    public Role(Set<Film> films, Set<Acteur> acteurs) {
        super();
        this.films = films;
        this.acteurs = acteurs;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setSingleFilm(Film film) {
        this.films.clear();
        this.films.add(film);
    }

    public void setSingleActeur(Acteur acteur) {
        this.acteurs.clear();
        this.acteurs.add(acteur);
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Set<Acteur> getActeurs() {
        return acteurs;
    }

    public void setActeurs(Set<Acteur> acteurs) {
        this.acteurs = acteurs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

}