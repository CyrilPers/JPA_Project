package fr.moviedb.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "lieu")
public class Lieu {
    @Id
    @Column(name = "id_lieu", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapsId("ville")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ville")
    private Ville ville;

    @MapsId("etatDpt")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etat_dpt")
    private EtatDpt etatDpt;

    @MapsId("pays")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays")
    private Pays pays;

    @OneToMany(mappedBy = "lieu")
    private Set<Film> films = new HashSet<>();


    @OneToMany(mappedBy = "lieu")
    private Set<Personne> personnes = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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