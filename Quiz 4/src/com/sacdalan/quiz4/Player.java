package com.sacdalan.quiz4;

public class Player {
    private int playerId;
    private String userName;
    private int level;

    public Player(int playerId, String userName, int level) {
        this.playerId = playerId;
        this.userName = userName;
        this.level = level;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return playerId == player.playerId && level == player.level && java.util.Objects.equals(userName, player.userName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(playerId, userName, level);
    }

    @Override
    public String toString() {
        return "Player{" +
                "ID :" + playerId +
                ", USER :'" + userName + '\'' +
                ", LEVEL :" + level +
                '}';
    }


}