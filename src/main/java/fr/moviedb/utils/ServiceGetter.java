package fr.moviedb.utils;

import fr.moviedb.services.*;

public class ServiceGetter {
    private static ActeurService acteurService;
    private static VilleService villeService;
    private static PaysService paysService;
    private static RealisateurService  realisateurService;
    private static LangueService langueService;
    private static EtatDptService etatDptService;
    private static LieuService lieuService;
    private static GenreService genreService;
    private static FilmService filmService;
    private static RoleService roleService;

    public static RoleService getRoleService() {
        if(roleService != null)
            return new RoleService();
        return new RoleService();
    }

    public static ActeurService getActeurService() {
        if (acteurService != null)
            return acteurService;
        return new ActeurService();
    }


    public static VilleService getVilleService() {
        if (villeService != null)
            return villeService;
        return new VilleService();
    }

    public static PaysService getPaysService() {
        if(paysService != null)
            return paysService;
        return new PaysService();
    }

    public static RealisateurService getRealisateurService() {
        if(realisateurService != null)
            return realisateurService;
        return new RealisateurService();
    }

    public static LangueService getLangueService() {
        if(langueService != null)
            return langueService;
        return new LangueService();
    }

    public static EtatDptService getEtatDptService() {
        if(etatDptService != null)
            return etatDptService;
        return new EtatDptService();
    }

    public static LieuService getLieuService() {
        if (lieuService != null)
            return lieuService;
        return new LieuService();
    }

    public static GenreService getGenreService() {
        if(genreService != null)
            return genreService;
        return new GenreService();
    }

    public static FilmService getFilmService() {
        if(filmService != null)
            return filmService;
        return new FilmService();
    }

}
