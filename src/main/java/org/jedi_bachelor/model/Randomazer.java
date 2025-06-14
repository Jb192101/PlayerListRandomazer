package org.jedi_bachelor.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Randomazer {
    public Randomazer() {

    }

    public List<Team> randomTeams(List<Player> _players, GeneratorRandomTeamName _nameGenerator) {
        if (_players == null || _players.size() < 4 || _players.size() > 8) {
            throw new IllegalArgumentException("Число игроков должно быть от 4 до 8 включительно!");
        }

        List<Player> sortedPlayers = new ArrayList<>(_players);
        Collections.sort(sortedPlayers, Collections.reverseOrder());

        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            teams.add(new Team(_nameGenerator.getNameTeam(), null, null));
        }

        for (int i = 0; i < sortedPlayers.size(); i++) {
            int teamIndex;
            if ((i / 4) % 2 == 0) {
                teamIndex = i % 4;
            } else {
                teamIndex = 4 - 1 - (i % 4);
            }

            Team team = teams.get(teamIndex);
            if (team.getPlayer1() == null) {
                team.setPlayer1(sortedPlayers.get(i));
            } else if (team.getPlayer2() == null) {
                team.setPlayer2(sortedPlayers.get(i));
            }
        }

        return teams;
    }
}
