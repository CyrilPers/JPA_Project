package fr.moviedb.entities;

import fr.moviedb.services.ManageFile;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class MovieDb {
    public static void main(String[] args) throws IOException {
            ManageFile manageFile = new ManageFile();
        try {
            manageFile.parseToDb();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
