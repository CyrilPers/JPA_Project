package fr.moviedb;

import fr.moviedb.entities.Film;
import fr.moviedb.services.FilmService;

import java.time.Year;
import java.util.Scanner;
import java.util.Set;

public class ConsoleSearch {


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
            }

        }

    }

    private static void displayMovieByPeriodAndActor(boolean addActor) {
        System.out.println("Veuillez la indiquer la période :");
        System.out.println("Début de période (année):");
        int startYear = scanner.nextInt();
        System.out.println("Fin de période (année) ");
        int endYear = scanner.nextInt();
        if (addActor) {

        } else {

        }
    }

    private static void displaySameActorsInMovies() {
        System.out.println("Veuillez indiquer le nom des films ");
        System.out.println("Film 1 :");
        String movie1 = scanner.nextLine();
        System.out.println("Film 2: ");
        String movie2 = scanner.nextLine();
    }

    private static void displayFilmWith2Actors() {
        System.out.println("Veuillez indiquer le nom des acteurs :");
        System.out.println("Acteur 1 (prénom et nom");
        String actor1 = scanner.nextLine();
        System.out.println("Acteur 2 (prénom et nom) :");
        String actor2 = scanner.nextLine();
        Set<Film> films = filmService.findByActors(actor1, actor2);
        if (films.isEmpty()) {
            System.out.println("Aucun film trouvé");
        } else {
            films.forEach(film -> System.out.println(film.toString()));
        }
    }

    private static void displayCastingByMovie() {
        System.out.println("Veuillez indiquer le nom du film :");
        String movieName = scanner.nextLine();

    }

    private static void displayMovieByActor() {
        System.out.println("Veuillez indiquer le prénom et le nom de l'acteur :");
        String acteurName = scanner.nextLine();
    }


}
