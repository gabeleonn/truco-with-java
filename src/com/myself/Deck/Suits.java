package com.myself.Deck;

public enum Suits {
    CLUBS(4), HEARTS(3), SPADES(2), DIAMONDS(1);
    public final int value;

    Suits(int i) {
        this.value = i;
    }
}
