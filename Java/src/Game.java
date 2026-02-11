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
    
    private List<Player> players;
    private Deck deck;
    private Player currentPlayer;

    public void startGame() {
        // start game
    }

    public void playTurn(Player player) {
        // play one turn
    }

    public boolean isGameOver() {
        return false;
    }

    public Player determineWinner() {
        return null;
    }

    public void nextPlayer() {
        // move to next player
    }

    public void displayScores() {
        // show scores
    }

}//end class

