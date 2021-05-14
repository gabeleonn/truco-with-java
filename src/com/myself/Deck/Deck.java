package com.myself.Deck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Deck {
    public Stack<Card> cards = new Stack<>();

    public Deck() {
        this.initDeck();
    }

    public void initDeck() {
        String[] cards = new String[]{ "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Jack", "Queen", "King" };
        List<Card> clubs = Arrays.stream(cards)
                                    .map(element -> new Card(Suits.CLUBS, element))
                                    .collect(Collectors.toList());
        List<Card> diamonds = Arrays.stream(cards)
                                    .map(element -> new Card(Suits.DIAMONDS, element))
                                    .collect(Collectors.toList());
        List<Card> spades = Arrays.stream(cards)
                                    .map(element -> new Card(Suits.SPADES, element))
                                    .collect(Collectors.toList());
        List<Card> hearts = Arrays.stream(cards)
                                    .map(element -> new Card(Suits.HEARTS, element))
                                    .collect(Collectors.toList());

        this.cards.addAll(clubs);
        this.cards.addAll(diamonds);
        this.cards.addAll(spades);
        this.cards.addAll(hearts);

        this.shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cards);
    }

    public Card cut() {
        int i = this.getSize() / 2;

        //List<Card> bottom = this.cards.subList(0, this.getSize() / 2);
        //List<Card> top = this.cards.subList(this.getSize() / 2, this.getSize());

        //this.cards.clear();
        //this.cards.addAll(top);
        //this.cards.addAll(bottom);

        return this.cards.remove(i);
    }

    public Card buy() {
        return this.cards.pop();
    }

    private int getSize() {
        return this.cards.size();
    }
}
