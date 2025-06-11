package org.jedi_bachelor.utils;

import lombok.Getter;

import java.io.*;

import java.util.List;
import java.util.Scanner;

@Getter
public class FilesReader {
    private List<String> names1;
    private List<String> names2;

    public FilesReader() {
        try {
            readFromFile();
        } catch(FileNotFoundException e) {
            System.out.println("FilesReader : Не найден файл!");
        }
    }

    private void readFromFile() throws FileNotFoundException {
        File file1 = new File("txt/names_of_teams_1.txt");
        File file2 = new File("txt/names_of_teams_2.txt");

        Scanner scan1 = new Scanner(file1);
        Scanner scan2 = new Scanner(file2);

        while(scan1.hasNextLine()) {
            names1.add(scan1.nextLine());
        }

        while(scan2.hasNextLine()) {
            names2.add(scan2.nextLine());
        }
    }

}
