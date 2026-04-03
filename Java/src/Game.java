/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Inder Partap Singh
 * @author Mohan Singh
 * @author Jaskarn Singh Gill
 * @author Milandeep Singh
 */

import java.util.ArrayList;
import java.util.List;

/**
 * The class that models your game. create a more specific child of this class and instantiate the methods
 * given.
 */
public abstract class Game {
    
     protected List<Player> players;
    protected Deck deck;
    protected Player currentPlayer;

    public void startGame() {
        deck.shuffle();
        for (Player p : players) {
            for (int i = 0; i < 5; i++) { // deal 5 cards
                p.drawCard(deck);
            }
        }
        currentPlayer = players.get(0);
    }

    public void playTurn(Player player) {
        String rank = player.chooseRankToAsk();
        Player other = players.get(1); // simplification: always ask 2nd player
        boolean gotCards = player.askForCard(rank, other);
        if (!gotCards) {
            player.drawCard(deck);
        }
        player.checkForBooks();
    }

    public boolean isGameOver() {
        return deck.isEmpty();
    }

    public Player determineWinner() {
        Player winner = players.get(0);
        for (Player p : players) {
            if (p.getBookCount() > winner.getBookCount()) {
                winner = p;
            }
        }
        return winner;
    }

    public void nextPlayer() {
        int index = players.indexOf(currentPlayer);
        currentPlayer = players.get((index + 1) % players.size());
    }

    public void displayScores() {
        for (Player p : players) {
            System.out.println(p.getName() + " has " + p.getBookCount() + " books.");
        }
    }

}

