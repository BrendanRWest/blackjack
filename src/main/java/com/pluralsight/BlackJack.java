package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        String hit;
        int highestHand = 0;
        int tie = 0;

        ArrayList<Player> players = new ArrayList<>();

        System.out.print("How many players will be playing blackjack? ");
        int numberOfPlayers = scan.nextInt();
        scan.nextLine();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.print("Enter the name of player " + i + ": ");
            name = scan.nextLine();

            Player player = new Player(name);
            players.add(player);
        }

        Deck deck = new Deck();
        deck.shuffle();

        for (int i = 0; i < 2; i++) {
            for (Player player : players) {
                player.getPlayerHand().deal(deck.deal());
            }
        }
        for (Player player : players) {

            if(player.getPlayerHand().getValue() == 21){
                System.out.println("Woo, " + player.getPlayerName() + " has blackjack!");
                continue;
            }
            System.out.println(player.getPlayerName() + " has " +
                    player.getPlayerHand().getValue());

            System.out.print("Would you like to hit? (y/n): ");
            hit = scan.nextLine();

            while(hit.equalsIgnoreCase("y")){
                player.getPlayerHand().deal(deck.deal());
                System.out.println(player.getPlayerName() + " has " +
                        player.getPlayerHand().getValue());
                if(player.getPlayerHand().getValue() == 21){
                    System.out.println("Woo, " + player.getPlayerName() + " has blackjack!");
                    hit = "n";
                } else if (player.getPlayerHand().getValue() > 21) {
                    System.out.println("Oh no, " + player.getPlayerName() +
                            " has busted!");
                    hit = "n";
                } else{
                    System.out.print("Would you like to hit again? (y/n): ");
                    hit = scan.nextLine();
                }
            }
        }

        for (Player player : players) {
            if(!player.hasBusted() && (player.getPlayerHand().getValue() > highestHand)){
                highestHand = player.getPlayerHand().getValue();
            }
        }

        for (Player player : players) {
            if (!player.hasBusted() &&
                    player.getPlayerHand().getValue() == highestHand) {
                tie++;
            }
        }

        if (highestHand == 0) {
            System.out.println("Everyone busted, what a bummer!");

        } else if (tie == 1) {
            for (Player player : players) {
               if(player.getPlayerHand().getValue() == highestHand){
                   System.out.println(player.getPlayerName() + " is the winner with " +
                           player.getPlayerHand().getValue() + "!");
               }
            }

        } else {
            System.out.println("These players are tied with " + highestHand + ":");
            for (Player player : players) {
                if(player.getPlayerHand().getValue() == highestHand){
                    System.out.println(player.getPlayerName());
                }
            }
        }
    }
}
