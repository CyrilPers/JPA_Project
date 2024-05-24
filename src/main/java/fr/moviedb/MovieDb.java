package fr.moviedb;

import fr.moviedb.fileManagement.ManageFile;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class MovieDb {
    public static void main(String[] args)  {
        try {
            ManageFile mf = new ManageFile();
            mf.parseToDb();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (java.text.ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
