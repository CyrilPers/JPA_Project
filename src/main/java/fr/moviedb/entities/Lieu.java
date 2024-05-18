package fr.moviedb.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "lieu")
public class Lieu {
    @Id
    @Column(name = "id_lieu", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ville", nullable = false)
    private Ville ville;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "etat_dpt", nullable = false)
    private EtatDpt etatDpt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pays", nullable = false)
    private Pays pays;

    public Lieu(Integer id, Ville ville, EtatDpt etatDpt, Pays pays) {
        this.ville = ville;
        this.etatDpt = etatDpt;
        this.pays = pays;
    }

    public Lieu() {

    }

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

}