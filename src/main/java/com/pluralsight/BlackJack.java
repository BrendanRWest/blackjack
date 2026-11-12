package com.pluralsight;

import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter player 1's name: ");
        String player1 = scan.nextLine();

        System.out.print("\nPlease enter player 2's name: ");
        String player2 = scan.nextLine();

        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        Deck deck1 = new Deck();
        deck1.shuffle();

        hand1.deal(deck1.deal());
        hand2.deal(deck1.deal());

        hand1.deal(deck1.deal());
        hand2.deal(deck1.deal());

        System.out.println(player1 + " has " + hand1.getValue());
        System.out.println(player2 + " has " + hand2.getValue());

        if(hand1.getValue() > hand2.getValue()){
            System.out.println(player1 + " wins!");
        } else {
            System.out.println(player2 + " wins!");
        }


    }
}
