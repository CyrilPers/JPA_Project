package fr.moviedb;

import fr.moviedb.services.ManageFile;

import java.io.IOException;

public class MovieDb {
    public static void main(String[] args) throws IOException {
            ManageFile manageFile = new ManageFile();
            manageFile.parseToDb();
    }
}
