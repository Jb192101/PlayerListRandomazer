package org.jedi_bachelor.model;

/*
Класс команды

Предполагается, что в ней находится максимум 2 игрока
 */

import lombok.Data;

@Data
public class Team {
    private Player player1;
    private Player player2;

    private String name;

    public Team(String _n, Player _p1, Player _p2) {
        this.name = _n;
        this.player1 = _p1;
        this.player2 = _p2;
    }

    public Team(String _n, Player _p1) {
        this.name = _n;
        this.player1 = _p1;
    }
}
