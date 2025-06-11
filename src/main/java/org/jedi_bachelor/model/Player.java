package org.jedi_bachelor.model;

public class Player implements Comparable<Player> {
    private String nickname;

    private int countOfBrokingBeds = 0;
    private int countOfKillings = 0;
    private int countOfDyings = 0;

    public Player(String _nick, int _c1, int _c2, int _c3) {
        if(_c1 >= 0 && _c2 >= 0 && _c3 >= 0) {
            this.nickname = _nick;
            this.countOfBrokingBeds = _c1;
            this.countOfKillings = _c2;
            this.countOfDyings = _c3;
        }
    }

    public void setKillings(int _c) {
        if(_c >= countOfKillings) {
            this.countOfKillings = _c;
        }
    }

    public void setDyings(int _c) {
        if(_c >= countOfDyings) {
            this.countOfDyings = _c;
        }
    }

    public void setBrokingsBeds(int _c) {
        if(_c >= countOfBrokingBeds) {
            this.countOfBrokingBeds = _c;
        }
    }

    public float getPlayerRating() {
        return 0.5f*countOfBrokingBeds + 0.25f*countOfKillings - 0.15f*countOfDyings;
    }

    @Override
    public int compareTo(Player o) {
        return 0;
    }
}
