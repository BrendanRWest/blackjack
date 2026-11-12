package com.pluralsight;

public class Player {

    private String playerName;
    private Hand playerHand;

    public Player(String name) {
        this.playerName = name;
        this.playerHand = new Hand();
    }

    public String getPlayerName() {
        return playerName;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }

    public boolean hasBusted(){
        return playerHand.getValue() > 21;
    }
}
