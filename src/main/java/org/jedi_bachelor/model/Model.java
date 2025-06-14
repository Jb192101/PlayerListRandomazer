package org.jedi_bachelor.model;

import java.util.List;

public class Model {
    private Randomazer r;
    private GeneratorRandomTeamName grtn;

    private List<Player> listOfPlayers;
    private List<Team> teams;

    public Model() {
        r = new Randomazer();
        grtn = new GeneratorRandomTeamName();
    }

    public List<Player> getPlayerList() {
        return this.listOfPlayers;
    }

    public void randomaze() {

    }
}
