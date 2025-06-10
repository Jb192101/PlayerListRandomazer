package org.jedi_bachelor.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jedi_bachelor.model.Team;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONWriter {
    private Gson gson;
    private final String PATH_TO_JSON = "players.json";

    public JSONWriter() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    // Метод записи в JSON-файл
    public void toJson(List<Team> _teams) {
        try {
            String json = gson.toJson(_teams);
            try (FileWriter writer = new FileWriter("players.json")) {
                writer.write(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Метод считывания из JSON-файла
    public List<Team> fromJson() {
        List<Team> result = new ArrayList<>();
        try {
            Path path = Paths.get(PATH_TO_JSON);
            if (Files.exists(path)) {
                Gson gson = new Gson();
                result = gson.fromJson(new FileReader(PATH_TO_JSON), List.class);
            } else {
                result = new ArrayList<Team>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
