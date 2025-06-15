package org.jedi_bachelor.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jedi_bachelor.model.Player;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JSONWriter {
    private Gson gson;
    private final String PATH_TO_JSON = "/user_data/players.json";

    public JSONWriter() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    // Метод записи в JSON-файл
    public void toJson(List<Player> _players) {
        try {
            String json = gson.toJson(_players);
            try (FileWriter writer = new FileWriter(PATH_TO_JSON)) {
                writer.write(json);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Метод по удалению игрока из JSON-файла
    public void removeFromJson(int _i) {
        try {
            List<Player> players = fromJson();

            // Удаляем команды, удовлетворяющие условию
            players.remove(_i);
            toJson(players);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод считывания из JSON-файла
    public List<Player> fromJson() {
        List<Player> result = new ArrayList<>();
        try {
            Path path = Paths.get(PATH_TO_JSON);
            if (Files.exists(path)) {
                Gson gson = new Gson();
                result = gson.fromJson(new FileReader(PATH_TO_JSON), List.class);
            } else {
                result = new ArrayList<Player>();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
