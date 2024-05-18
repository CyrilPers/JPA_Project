package fr.moviedb;

import fr.moviedb.services.ManageFile;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class MovieDb {
    public static void main(String[] args) {
        ManageFile manageFile = new ManageFile();
        try {
            manageFile.parseToDb();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
