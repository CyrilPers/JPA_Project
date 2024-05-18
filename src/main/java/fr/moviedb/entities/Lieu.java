package fr.moviedb;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lieu")
public class Lieu {
    @Id
    @Column(name = "id_lieu", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code_insee", nullable = false)
    private Ville codeInsee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code_insee_1", nullable = false)
    private EtatDpt codeInsee1;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "code_insee_2", nullable = false)
    private Pay codeInsee2;

    @OneToMany(mappedBy = "idLieu")
    private Set<Film> films = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idLieu")
    private Set<Personne> personnes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ville getCodeInsee() {
        return codeInsee;
    }

    public void setCodeInsee(Ville codeInsee) {
        this.codeInsee = codeInsee;
    }

    public EtatDpt getCodeInsee1() {
        return codeInsee1;
    }

    public void setCodeInsee1(EtatDpt codeInsee1) {
        this.codeInsee1 = codeInsee1;
    }

    public Pay getCodeInsee2() {
        return codeInsee2;
    }

    public void setCodeInsee2(Pay codeInsee2) {
        this.codeInsee2 = codeInsee2;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public Set<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(Set<Personne> personnes) {
        this.personnes = personnes;
    }

}