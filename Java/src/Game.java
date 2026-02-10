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

/**
 * The class that models your game. create a more specific child of this class and instantiate the methods
 * given.
 */
public abstract class Game {
    





    private final String name;//the title of the game
    private ArrayList<Players> players;// the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Players> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Players> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class

