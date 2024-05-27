package fr.moviedb.fileManagement;

import fr.moviedb.entities.*;
import fr.moviedb.services.*;
import fr.moviedb.utils.ConnectionEntityManager;
import fr.moviedb.utils.ServiceGetter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


public class ManageFile {

    private final VilleService villeService = ServiceGetter.getVilleService();
    private final PaysService paysService = ServiceGetter.getPaysService();
    private final ActeurService acteurService = ServiceGetter.getActeurService();
    private final RealisateurService realisateurService = ServiceGetter.getRealisateurService();
    private final LangueService langueService = ServiceGetter.getLangueService();
    private final EtatDptService etatDptService = ServiceGetter.getEtatDptService();
    private final LieuService lieuService = ServiceGetter.getLieuService();
    private final GenreService genreService = ServiceGetter.getGenreService();
    private final FilmService filmService = ServiceGetter.getFilmService();
    private final RoleService roleService = ServiceGetter.getRoleService();

    public void parseToDb() throws IOException, ParseException, java.text.ParseException {
        String filePath = "src/main/resources/files/films.json";
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(filePath));
        JSONArray filmList = (JSONArray) object; //
        Iterator<JSONObject> iterator = filmList.iterator();
        while (iterator.hasNext()) {
            JSONObject jFilm = iterator.next();
            Film film = new Film();
            boolean saveFilm = filmService.find(jFilm.get("id").toString()) == null ? true : false;
            while (saveFilm) {
                System.out.println("PAS TROUVE " + jFilm.get("id").toString());
                film.setIdFilm(jFilm.get("id").toString());
                if (jFilm.containsKey("nom") && jFilm.get("nom") != null && !jFilm.get("nom").toString().isBlank()) {
                    film.setNom(jFilm.get("nom").toString());
                }

                if (jFilm.containsKey("anneeSortie") && jFilm.get("anneeSortie") != null) {
                    String anneeSortie = jFilm.get("anneeSortie").toString();
                    String YearSortie = anneeSortie.substring(0, 4);
                    film.setAnnee(Integer.parseInt(YearSortie));
                }
                if (jFilm.containsKey("rating") && jFilm.get("rating") != null) {
                    if (!jFilm.get("rating").toString().isBlank()) {
                        System.out.println(jFilm.get("rating").toString());
                        try {
                            film.setRating(new BigDecimal(jFilm.get("rating").toString()));
                        } catch (Exception e) {
                        }
                    }
                }
                if (jFilm.containsKey("url") && jFilm.get("url") != null) {
                    film.setUrl((String) jFilm.get("url"));
                }
                if (jFilm.containsKey("lieuTournage") && jFilm.get("lieuTournage") != null) {
                    Lieu lieu = convertLieu((JSONObject) jFilm.get("lieuTournage"));
                    film.setLieu(lieu);
                }
                if (jFilm.containsKey("genres") && jFilm.get("genres") != null) {
                    Set<Genre> genres = convertGenres((JSONArray) jFilm.get("genres"));
                    film.setGenres(genres);
                }
                if (jFilm.containsKey("langue") && jFilm.get("langue") != null) {
                    Langue langue = getLangue(jFilm.get("langue").toString());
                    film.setLangue(langue);
                }
                if (jFilm.containsKey("plot") && jFilm.get("plot") != null) {
                    film.setResume(jFilm.get("plot").toString());
                }
                if (jFilm.containsKey("pays") && jFilm.get("pays") != null) {
                    JSONObject jPays = (JSONObject) jFilm.get("pays");
                    if (jPays.containsKey("nom") && jPays.get("nom") != null) {
                        Pays pays = paysService.add(jPays.get("nom").toString());
                        film.setPays(pays);
                    }
                }
                if (jFilm.containsKey("realisateurs") && jFilm.get("realisateurs") != null) {
                    JSONArray realisateurs = (JSONArray) jFilm.get("realisateurs");
                    if (realisateurs.size() > 0) {
                        Set<Realisateur> realisateurList = convertRealisateurs(realisateurs);
                        film.setRealisateurs(realisateurList);
                    }
                }
                filmService.add(film);
                if (jFilm.containsKey("castingPrincipal") && jFilm.get("castingPrincipal") != null) {
                    JSONArray castingPrincipal = (JSONArray) jFilm.get("castingPrincipal");
                    if (castingPrincipal.size() > 0) {
                        Set<Role> roles = new HashSet<>();
                        Set<Acteur> acteursList = convertActeurs(castingPrincipal);
                        acteursList.forEach(act -> {
                            Role role = new Role();
                            role.setSingleActeur(act);
                            role.setSingleFilm(film);
                            roleService.add(role);
                        });
                        film.setRoles(roles);
                    }
                }
                if (jFilm.containsKey("roles") && jFilm.get("roles") != null) {
                    JSONArray roles = (JSONArray) jFilm.get("roles");
                    if (!roles.isEmpty()) {
                        Set<Role> filmRoles = createRole(roles, film);
                        film.setRoles(filmRoles);
                    }
                }
                saveFilm = false;
            }
        }
        System.out.println("COPIE EN BDD TERMINEE !");
        ConnectionEntityManager.closeEM();
    }

    private Set<Role> createRole(JSONArray roles, Film film) throws java.text.ParseException {
        Iterator<JSONObject> iterator = roles.iterator();
        Set<Role> roleList = new HashSet<>();
        while (iterator.hasNext()) {
            JSONObject jRole = iterator.next();
            Acteur acteur = null;
            Role role = null;
            if (jRole.containsKey("acteur")) {
                JSONObject jActeur = (JSONObject) jRole.get("acteur");
                if (jActeur.containsKey("id") && jActeur.get("id") != null) {
                    acteur = acteurService.findById(jActeur.get("id").toString());
                    if (acteur == null) {
                        acteur = convertActeur(jActeur);
                        Realisateur realisateur = realisateurService.findById(jActeur.get("id").toString());
                        if (realisateur == null) {
                            acteur = acteurService.add(acteur);
                        } else {
                            acteur = acteurService.setRealisateurAsActeur(acteur);
                        }
                    }
                }
            }
            role = roleService.findRoleWithoutPersonnage(film, acteur);
            if (role == null) {
                role = new Role();
                role.setSingleFilm(film);
                role.setSingleActeur(acteur);
            }
            if (jRole.containsKey("characterName") && jRole.get("characterName") != null) {
                role.setPersonnage(jRole.get("characterName").toString());
            }
            roleService.add(role);
            roleList.add(role);
        }
        return roleList;
    }

    /**
     * @param castingPrincipal
     * @return
     */
    private Set<Acteur> convertActeurs(JSONArray castingPrincipal) throws java.text.ParseException {
        Iterator<JSONObject> iterator = castingPrincipal.iterator();
        Set<Acteur> acteurList = new HashSet<>();
        while (iterator.hasNext()) {
            JSONObject jActeur = iterator.next();
            if (jActeur.containsKey("id")) {
                Acteur acteurFound = acteurService.findById(jActeur.get("id").toString());
                if (acteurFound != null) {
                    acteurList.add(acteurFound);
                } else {
                    Realisateur realisateur = realisateurService.findById(jActeur.get("id").toString());
                    Acteur acteur = convertActeur(jActeur);
                    if (realisateur != null) {
                        acteurService.setRealisateurAsActeur(acteur);
                    } else {
                        acteurService.add(acteur);

                    }
                    acteurList.add(acteur);
                }
            }
        }
        return acteurList;
    }

    private Acteur convertActeur(JSONObject jActeur) throws java.text.ParseException {
        Acteur acteur = new Acteur();
        acteur.setIdPersonne(jActeur.get("id").toString());
        if (jActeur.containsKey("identite")) {
            acteur.setIdentite(jActeur.get("identite").toString());
        }
        if (jActeur.containsKey("url")) {
            acteur.setUrl((String) jActeur.get("url"));
        }
        if (jActeur.containsKey("height")) {
                String numericPart = jActeur.get("height").toString().replace("m", "").trim();
                System.out.println("taille :" + numericPart);
            try {
                acteur.setTaille(new BigDecimal(numericPart));
            } catch (Exception e) {
            }
        }
        if (jActeur.containsKey("naissance")) {
            JSONObject naissance = (JSONObject) jActeur.get("naissance");
            if (naissance.containsKey("dateNaissance")) {
                if (!naissance.get("dateNaissance").toString().isBlank()) {
                    try {
                        Date date = convertToDate(naissance.get("dateNaissance").toString());
                        acteur.setDateNaissance(date);
                    } catch (java.text.ParseException e) {
                    }
                }
            }
            if (naissance.containsKey("lieuNaissance") && naissance.get("lieuNaissance") != null) {
                if (!naissance.get("lieuNaissance").toString().isBlank()) {
                    Lieu lieuNaissance = convertLieuNaissance(naissance.get("lieuNaissance").toString());
                    lieuService.add(lieuNaissance);
                    acteur.setLieu(lieuNaissance);
                }
            }
        }
        return acteur;
    }

    /**
     * @param realisateurs
     * @return
     */
    private Set<Realisateur> convertRealisateurs(JSONArray realisateurs) throws java.text.ParseException {
        Iterator<JSONObject> iterator = realisateurs.iterator();
        Set<Realisateur> realisateurList = new HashSet<>();
        while (iterator.hasNext()) {
            JSONObject jRealisateur = iterator.next();
            if (jRealisateur.containsKey("id")) {
                Realisateur realisateurFound = realisateurService.findById(jRealisateur.get("id").toString());
                if (realisateurFound != null) {
                    realisateurList.add(realisateurFound);
                } else {
                    Realisateur realisateur = new Realisateur();
                    realisateur.setIdPersonne(jRealisateur.get("id").toString());
                    if (jRealisateur.containsKey("identite")) {
                        realisateur.setIdentite(jRealisateur.get("identite").toString());
                    }
                    if (jRealisateur.containsKey("url")) {
                        realisateur.setUrl(jRealisateur.get("url").toString());
                    }
                    if (jRealisateur.containsKey("naissance")) {
                        JSONObject naissance = (JSONObject) jRealisateur.get("naissance");
                        if (naissance.containsKey("dateNaissance") && naissance.get("dateNaissance") != null) {
                            if (!naissance.get("dateNaissance").toString().isBlank()) {
                                try {
                                    Date date = convertToDate(naissance.get("dateNaissance").toString());
                                    realisateur.setDateNaissance(date);
                                } catch (java.text.ParseException e) {
                                }
                            }
                        }
                        if (naissance.containsKey("lieuNaissance") && naissance.get("lieuNaissance") != null) {
                            if (!naissance.get("lieuNaissance").toString().isBlank()) {
                                Lieu lieu = convertLieuNaissance(naissance.get("lieuNaissance").toString());
                                realisateur.setLieu(lieu);
                            }
                        }
                    }
                    Acteur acteur = acteurService.findById(realisateur.getIdPersonne());
                    if (acteur != null) {
                        realisateurService.setActeurAsRealisateur(realisateur);
                    } else {
                        realisateurService.add(realisateur);
                    }
                    realisateurList.add(realisateur);
                }
            }

        }
        return realisateurList;
    }

    /**
     * @param langueName
     * @return
     */
    private Langue getLangue(String langueName) {
        Langue langue = langueService.add(langueName);
        return langue;
    }


    /**
     * @param lieuNaissance
     * @return
     */
    private Lieu convertLieuNaissance(String lieuNaissance) {
        String[] lieuElements = lieuNaissance.split(",");

        Lieu lieu;
        if (lieuElements.length < 2) {
            Pays pays = paysService.add(lieuElements[0]);
            lieu = new Lieu(pays);
        } else if (lieuElements.length < 3) {
            Ville ville = villeService.add(lieuElements[0]);
            Pays pays = paysService.add(lieuElements[1]);
            lieu = new Lieu(ville, pays);
        } else {
            Ville ville = villeService.add(lieuElements[0]);
            EtatDpt etatDpt = etatDptService.add(lieuElements[1]);
            System.out.println(lieuElements[2]);
            Pays pays = paysService.add(lieuElements[2]);
            lieu = new Lieu(ville, etatDpt, pays);
        }
        lieuService.add(lieu);
        return lieu;
    }

    /**
     * @param jlieu
     * @return
     */
    private Lieu convertLieu(JSONObject jlieu) {
        Lieu lieu = new Lieu();
        if (jlieu.containsKey("ville") && !jlieu.get("ville").toString().isEmpty()) {
            Ville ville = villeService.add(jlieu.get("ville").toString());
            lieu.setVille(ville);
        }
        if (jlieu.containsKey("pays") && !jlieu.get("pays").toString().isEmpty()) {
            Pays pays = paysService.add(jlieu.get("pays").toString());
            lieu.setPays(pays);
        }
        if (jlieu.containsKey("etatDept") && jlieu.get("etatDept") != null) {
            EtatDpt etatDpt = etatDptService.add(jlieu.get("etatDept").toString());
            lieu.setEtatDpt(etatDpt);
        }
        lieuService.add(lieu);
        return lieu;
    }

    /**
     * @param genreList
     * @return
     */
    private Set<Genre> convertGenres(JSONArray genreList) {
        Set<Genre> genres = new HashSet<>();
        for (Object genreName : genreList) {
            Genre genre = genreService.add(genreName.toString());
            genres.add(genre);
        }
        return genres;
    }


    private Date convertToDate(String dateNaissance) throws java.text.ParseException {
        dateNaissance = dateNaissance.trim();
        if (dateNaissance.split(" ").length < 2) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy", Locale.ENGLISH);
            return dateFormat.parse(dateNaissance);
        }
        if (dateNaissance.split(" ").length < 3) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
            return dateFormat.parse(dateNaissance);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd yyyy", Locale.ENGLISH);
        return dateFormat.parse(dateNaissance);
    }
}
