package fr.moviedb.services;

import fr.moviedb.entities.Acteur;
import fr.moviedb.entities.Film;
import fr.moviedb.entities.Role;
import fr.moviedb.repository.RoleRepository;

public class RoleService {

    private RoleRepository roleRepository = new RoleRepository();

    public Role add(Role role) {
        return roleRepository.save(role);
    }

    public Role findRoleWithoutPersonnage(Film film, Acteur acteur) {
        return roleRepository.findRoleWithoutPersonnage(film, acteur) ;
    }

}
