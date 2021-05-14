package com.myself;

import com.myself.Deck.Card;
import com.myself.Deck.Deck;
import com.myself.Game.Player;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static Deck deck;
    public static List<Card> desk;
    public static Card joker;
    public static int turn = 1;
    public static int turnOneWinner = 0;
    public static int turnTwoWinner = 0;
    public static int turnThreeWinner = 0;
    public static Player player;
    public static Player computer;

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        System.out.println("Seja bem vindo!");
        System.out.print("Qual o seu nome? ");

	    String playerName = scan.nextLine();
        player = new Player(playerName);
        computer = new Player("Computer");
        System.out.println("#-------------------------------------------------#");

        init();

        player.hand.add(deck.buy());
        computer.hand.add(deck.buy());
        player.hand.add(deck.buy());
        computer.hand.add(deck.buy());
        player.hand.add(deck.buy());
        computer.hand.add(deck.buy());

        while (turn <= 3) {
            if (turn == 1) {
                handleTurnOne();
            } else if (turn == 2) {
                handleTurnTwo();
            } else {
                handleTurnThree();
            }
            System.out.println("#-------------------------------------------------#");
        }
    }

    public static void init() {
        shuffle();
        deal();
        cutAndGetJoker();
    }

    public static void shuffle() {
        deck = new Deck();
    }

    public static void cutAndGetJoker() {
        joker = deck.cut();
    }

    public static void deal() {
        //deal cards to players
    }

    public static void handleTurnOne() {
        System.out.println("Turno 1");
        player.showCards();
        System.out.print("Digite o número da carta que deseja jogar? ");
        Scanner scan = new Scanner(System.in);
        int entry = scan.nextInt();
        compareTurn(player.play(entry), computer.play(1));
        turn++;
    }

    public static void handleTurnTwo() {
        System.out.println("Turno 2");
        player.showCards();
        System.out.print("Digite o número da carta que deseja jogar? ");
        Scanner scan = new Scanner(System.in);
        int entry = scan.nextInt();
        compareTurn(player.play(entry), computer.play(1));
        handleWinner();
        turn++;
    }

    public static void handleTurnThree() {
        System.out.println("Turno 3");
        player.showCards();
        System.out.print("Digite o número da carta que deseja jogar? ");
        Scanner scan = new Scanner(System.in);
        int entry = scan.nextInt();
        compareTurn(player.play(entry), computer.play(1));
        handleWinner();
    }

    public static void compareTurn(Card player, Card computer) {
        if(turn == 1) {
            if (player.getValue() == computer.getValue()) {
                System.out.println("Draw-> get Higher");
            }
        }

        System.out.println("A carta do player é: " + player);
        System.out.println("A carta do computer é: " + computer);

        if (player.getValue() == computer.getValue() && turn != 1) {
            var playerSuit = player.getSuit();
            var computerSuit = computer.getSuit();

            if(playerSuit.value > computerSuit.value) {
                System.out.println("Ganhador do round é o player");
                setRoundWinner(1);
            } else {
                System.out.println("Ganhador do round é o computer");
                setRoundWinner(2);
            }
        } else if ((player.getValue() > computer.getValue())) {
            System.out.println("Ganhador do round é o player");
            setRoundWinner(1);
        } else {
            System.out.println("Ganhador do round é o computer");
            setRoundWinner(2);
        }
    }

    public static void setRoundWinner(int winner) {
        switch (turn) {
            case 1:
                turnOneWinner = winner;
                break;
            case 2:
                turnTwoWinner = winner;
                break;
            case 3:
                turnThreeWinner = winner;
                break;
            default:
                System.out.println("Error...");
        }
    }

    public static void handleWinner() {
        if ((turnTwoWinner == turnOneWinner) || (turnTwoWinner == turnThreeWinner) || (turnOneWinner == turnThreeWinner)) {
            String winner = turnTwoWinner == 1  ? player.name : "Computer";
            System.out.println("O jogo terminou: " + winner + " ganhou!");
            turn = 10;
        }
    }
}
