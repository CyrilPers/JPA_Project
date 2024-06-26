package fr.moviedb;

import fr.moviedb.entities.Acteur;
import fr.moviedb.entities.Film;
import fr.moviedb.services.ActeurService;
import fr.moviedb.services.FilmService;

import java.util.*;

public class SearchConsole {


    private static FilmService filmService = new FilmService();
    private static ActeurService acteurService = new ActeurService();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("Veuillez selectionner le mode d'affichage :");
            System.out.println("1. Affichage de la filmographie d’un acteur donné");
            System.out.println("2. Affichage du casting d’un film donné");
            System.out.println("3. Afichage des films sortis entre 2 années données");
            System.out.println("4. Affichage des films communs à 2 acteurs/actrices donnés");
            System.out.println("5. Affichage des acteurs communs à 2 films donnés");
            System.out.println("6. Affichage des films sortis entre 2 années données et qui ont un acteur/actrice donné au casting");
            System.out.println("7. Fin de l’application");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    displayMovieByActor();
                    break;
                case 2:
                    displayCastingByMovie();
                    break;
                case 3:
                    displayMovieByPeriodAndActor(false);
                    break;
                case 4:
                    displayFilmWith2Actors();
                    break;
                case 5:
                    displaySameActorsInMovies();
                    break;
                case 6:
                    displayMovieByPeriodAndActor(true);
                    break;
                case 7:
                    System.out.println("Fin de l'applicaiton");
                    running = false;
                    break;
                default:
                    System.err.println("Veuillez rentrer un chiffre entre 1 et 7 correspondant à votre choix");
                    break;
            }
        }

    }

    private static void displayMovieByPeriodAndActor(boolean addActor) {
        List<Film> films = new ArrayList<>();
        System.out.println("Veuillez indiquer la période :");
        System.out.println("Début de période (année):");
        int startYear = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Fin de période (année) :");
        int endYear = scanner.nextInt();
        scanner.nextLine();

        if (addActor) {
            System.out.println("Nom de l'acteur :");
            String actorName = scanner.nextLine();
            films = filmService.findByPeriodAndActors(startYear, endYear, actorName);
        } else {
            films = filmService.findByPeriod(startYear, endYear);
        }

        if (films.isEmpty()) {
            System.out.println("Aucun film trouvé");
        } else {
            System.out.println("Liste des films :");
            films.forEach(film -> System.out.println(film.toString()));
        }
    }

    private static void displaySameActorsInMovies() {
        System.out.println("Veuillez indiquer le nom des films ");
        System.out.println("Film 1 :");
        String movie1 = scanner.nextLine();
        System.out.println("Film 2: ");
        String movie2 = scanner.nextLine();
        List<Acteur> acteurs = acteurService.findSameActorsInMovies(movie1, movie2);
        if (acteurs.isEmpty()) {
            System.out.println("Aucun acteurs trouvés");
        } else {
            acteurs.forEach(acteur -> System.out.println(acteur.toString()));
        }
    }

    private static void displayFilmWith2Actors() {
        System.out.println("Veuillez indiquer le nom des acteurs :");
        System.out.println("Acteur 1 (prénom et nom");
        String actor1 = scanner.nextLine();
        System.out.println("Acteur 2 (prénom et nom) :");
        String actor2 = scanner.nextLine();
        List<Film> films = filmService.findByActors(actor1, actor2);
        if (films.isEmpty()) {
            System.out.println("Aucun film trouvé");
        } else {
            films.forEach(film -> System.out.println(film.toString()));
        }
    }

    private static void displayCastingByMovie() {
        System.out.println("Veuillez indiquer le nom du film :");
        String movieName = scanner.nextLine();
        List<Acteur> acteurs = acteurService.findByMovie(movieName);
        if (acteurs.isEmpty()) {
            System.out.println("Aucun acteur trouvé");
        } else {
            acteurs.forEach(acteur -> System.out.println(acteur.toString()));
        }
    }

    private static void displayMovieByActor() {
        System.out.println("Veuillez indiquer le prénom et le nom de l'acteur :");
        String actorName = scanner.nextLine();
        List<Film> films = filmService.findByActor(actorName);
        if (films.isEmpty()) {
            System.out.println("Aucun film trouvé");
        } else {
            films.forEach(film -> System.out.println(film.toString()));
        }
    }
}
