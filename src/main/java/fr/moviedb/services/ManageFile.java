package fr.moviedb.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.moviedb.entities.Film;

import java.io.File;
import java.io.IOException;

public class parseToDb {
    File file = new File("files/films.json");
    ObjectMapper objectMapper = new ObjectMapper();
    Film film = objectMapper.readValue(file, Film.class);
        Film film = objectMapper.readValue(new File("output.json"), Staff.class);


}
