package com.myself.Deck;

public class Card {
    private Suits suit;
    private String name;
    private String id;
    private int value;

    public Card(Suits suit, String id) {
        this.suit = suit;
        this.name = id +  " of " + suit.toString().toLowerCase();
        this.id = id;
        switch (id) {
            case "Four":
                this.value = 1;
                break;
            case "Five":
                this.value = 2;
                break;
            case "Six":
                this.value = 3;
                break;
            case "Seven":
                this.value = 4;
                break;
            case "Jack":
                this.value = 5;
                break;
            case "Queen":
                this.value = 6;
                break;
            case "King":
                this.value = 7;
                break;
            case "Ace":
                this.value = 8;
                break;
            case "Two":
                this.value = 9;
                break;
            case "Three":
                this.value = 10;
                break;
            default:
                this.value = 0;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
