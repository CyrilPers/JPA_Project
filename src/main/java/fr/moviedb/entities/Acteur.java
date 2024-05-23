package fr.moviedb.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="acteur")
public class Acteur extends Personne{

    @Column(name = "taille", precision = 4, scale = 2)
    private BigDecimal taille;

    @ManyToMany
    @JoinTable(name = "asso_11",
            inverseJoinColumns = @JoinColumn(name = "id_role"),
            joinColumns = @JoinColumn(name = "id_personne"))
    private Set<Role> roles = new HashSet<>();

    public BigDecimal getTaille() {
        return taille;
    }

    public void setTaille(BigDecimal taille) {
        this.taille = taille;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setSingleRole(Role role) {
        this.roles.clear();
        this.roles.add(role);
    }

    @Override
    public String toString() {
        return "Acteur : [ identité : " + getIdentite() + " taille " + taille +" ]";
    }

}