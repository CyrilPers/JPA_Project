package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lieu")
public class Lieu {
    @EmbeddedId
    private LieuId id;

    @MapsId("ville")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ville", nullable = false)
    private Ville ville;

    @MapsId("etatDpt")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etat_dpt", nullable = false)
    private EtatDpt etatDpt;

    @MapsId("pays")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    private Pays pays;

    @OneToMany(mappedBy = "lieu")
    private Set<Film> films = new LinkedHashSet<>();

    @OneToMany(mappedBy = "lieu")
    private Set<Personne> personnes = new LinkedHashSet<>();


    public LieuId getId() {
        return id;
    }

    public void setId(LieuId id) {
        this.id = id;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public EtatDpt getEtatDpt() {
        return etatDpt;
    }

    public void setEtatDpt(EtatDpt etatDpt) {
        this.etatDpt = etatDpt;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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