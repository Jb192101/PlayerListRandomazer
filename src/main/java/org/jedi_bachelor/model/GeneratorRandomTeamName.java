package org.jedi_bachelor.model;

import org.jedi_bachelor.utils.FilesReader;

import java.util.ArrayList;
import java.util.Random;

public class GeneratorRandomTeamName {
    private final FilesReader fr = new FilesReader();

    public String getNameTeam() {
        ArrayList<String> list1 = (ArrayList<String>) fr.getNames1();
        ArrayList<String> list2 = (ArrayList<String>) fr.getNames2();

        Random r = new Random();
        int randomIndex1 = r.nextInt(list1.size());
        int randomIndex2 = r.nextInt(list2.size());

        return list1.get(randomIndex1) + " " + list2.get(randomIndex2);
    }

}
