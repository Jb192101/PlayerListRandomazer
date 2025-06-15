package org.jedi_bachelor.utils;

import lombok.Getter;

import java.io.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class FilesReader {
    private List<String> names1;
    private List<String> names2;

    public FilesReader() {
        names1 = new ArrayList<>();
        names2 = new ArrayList<>();

        try {
            readFromFile();
        } catch(IOException e) {
            System.out.println("FilesReader : Не найден файл!");
        }
    }

    private void readFromFile() throws IOException {
        InputStream inputStream1 = getClass().getClassLoader().getResourceAsStream("txt/names_of_teams_1.txt");
        InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream("txt/names_of_teams_2.txt");

        if (inputStream1 == null || inputStream2 == null) {
            throw new RuntimeException("Файл не найден!");
        }

        String content1 = new String(inputStream1.readAllBytes(), StandardCharsets.UTF_8);
        String content2 = new String(inputStream2.readAllBytes(), StandardCharsets.UTF_8);

        String[] content11 = content1.split("\\|");
        String[] content21 = content2.split("\\|");

        for(int i = 0; i < content11.length; i++) {
            names1.add(content11[i]);
        }

        for(int i = 0; i < content21.length; i++) {
            names2.add(content21[i]);
        }
    }

}
