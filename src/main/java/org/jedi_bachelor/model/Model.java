package org.jedi_bachelor.model;

import org.jedi_bachelor.utils.JSONWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Model {
    private Randomazer r;
    private GeneratorRandomTeamName grtn;
    JSONWriter jsw;

    private List<Player> listOfPlayers;
    private List<Team> teams;

    public Model() {
        jsw = new JSONWriter();
        r = new Randomazer();
        grtn = new GeneratorRandomTeamName();

        listOfPlayers = new ArrayList<>();
        teams = new ArrayList<>();
    }

    public List<Player> getPlayerList() {
        return this.listOfPlayers;
    }

    public void addPlayer(Player _p) {
        listOfPlayers.add(_p);
        System.out.println("Список игроков: " + listOfPlayers);
        jsw.toJson(listOfPlayers);
    }

    public void randomaze() {
        if (listOfPlayers == null || listOfPlayers.size() < 4 || listOfPlayers.size() > 8) {
            throw new IllegalStateException("Число игроков от 4 до 8");
        }
        this.teams = r.randomTeams(listOfPlayers, grtn);
    }

    public boolean removePlayer(String _nick) {
        for(int i = 0; i < listOfPlayers.size(); i++) {
            if(Objects.equals(listOfPlayers.get(i).getNickname(), _nick)) {
                listOfPlayers.remove(i);
                jsw.removeFromJson(i);
                return true;
            }
        }

        return false;
    }
}
