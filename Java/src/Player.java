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
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 */
public abstract class Player {


    private String name;
    private Hand hand;
    private List<Book> books;

    public void drawCard(Deck deck) {
        // draw card from deck
    }

    public boolean askForCard(String rank, Player otherPlayer) {
        return false;
    }

    public List<Book> checkForBooks() {
        return new ArrayList<>();
    }

    public String chooseRankToAsk() {
        return "";
    }

    public void showHand() {
        // show player hand
    }

    public boolean hasRank(String rank) {
        return false;
    }

}


