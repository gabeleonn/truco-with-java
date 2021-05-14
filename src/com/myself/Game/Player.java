package com.myself.Game;

import com.myself.Deck.Card;

import java.util.Stack;

public class Player {
    public String name;
    public Stack<Card> hand = new Stack<>();
    public int points;
    public int roundPoints;

    public Player(String name) {
        this.name = name;
    }

    public Card play(int i) {
        return this.hand.remove(i - 1);
    }

    public void showCards() {
        int count = 1;
        for (Card card : hand) {
            System.out.print( count + ") " + card.toString() + "\t");
            if(hand.size() == count) {
                System.out.println();
            }
            count++;
        }
    }
}
