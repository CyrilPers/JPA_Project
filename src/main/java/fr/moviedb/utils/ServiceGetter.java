package fr.moviedb.utils;

import fr.moviedb.services.*;

public class ServiceGetter {
    private static ActeurService acteurService = ServiceGetter.getActeurService();
    private static VilleService villeService = ServiceGetter.getVilleService();
    private static PaysService paysService = ServiceGetter.getPaysService();
    private static AJoueService aJoueService = ServiceGetter.getAJoueService();
    private static RealisateurService  realisateurService = ServiceGetter.getRealisateurService();
    private static LangueService langueService = ServiceGetter.getLangueService();
    private static EtatDptService etatDptService = ServiceGetter.getEtatDptService();
    private static LieuService lieuService = ServiceGetter.getLieuService();
    private static GenreService genreService = ServiceGetter.getGenreService();
    private static FilmService filmService = ServiceGetter.getFilmService();

    private static ActeurService getActeurService() {
        if (acteurService != null)
            return acteurService;
        return new ActeurService();
    }


    private static VilleService getVilleService() {
        if (villeService != null)
            return villeService;
        return new VilleService();
    }

    private static PaysService getPaysService() {
        if(paysService != null)
            return paysService;
        return new PaysService();
    }

    private static AJoueService getAJoueService() {
        if(aJoueService != null)
            return aJoueService;
        return new AJoueService();
    }

    private static RealisateurService getRealisateurService() {
        if(realisateurService != null)
            return realisateurService;
        return new RealisateurService();
    }

    private static LangueService getLangueService() {
        if(langueService != null)
            return langueService;
        return new LangueService();
    }

    private static EtatDptService getEtatDptService() {
        if(etatDptService != null)
            return etatDptService;
        return new EtatDptService();
    }

    private static LieuService getLieuService() {
        if (lieuService != null)
            return lieuService;
        return new LieuService();
    }

    private static GenreService getGenreService() {
        if(genreService != null)
            return genreService;
        return new GenreService();
    }

    private static FilmService getFilmService() {
        if(filmService != null)
            return filmService;
        return new FilmService();
    }

}
