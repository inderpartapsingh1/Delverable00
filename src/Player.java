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


    protected String name;
    protected Hand hand = new Hand();
    protected List<Book> books = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck) {
        Card c = deck.dealCard();
        if (c != null) hand.addCard(c);
    }

    public boolean askForCard(String rank, Player otherPlayer) {
        List<Card> taken = otherPlayer.hand.getCardsOfRank(rank);
        if (!taken.isEmpty()) {
            for (Card c : taken) {
                otherPlayer.hand.removeCard(c);
                hand.addCard(c);
            }
            return true;
        }
        return false;
    }

    public List<Book> checkForBooks() {
        List<Book> newBooks = new ArrayList<>();
        for (String r : new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"}) {
            List<Card> cardsOfRank = hand.getCardsOfRank(r);
            if (cardsOfRank.size() == 4) {
                Book b = new Book(r);
                for (Card c : cardsOfRank) {
                    b.addCard(c);
                    hand.removeCard(c);
                }
                books.add(b);
                newBooks.add(b);
            }
        }
        return newBooks;
    }

    public String chooseRankToAsk() {
        if (!hand.getCards().isEmpty()) {
            return hand.getCards().get(0).getRank(); // pick first card for simplicity
        }
        return null;
    }

    public void showHand() {
        hand.showHand();
    }

    public boolean hasRank(String rank) {
        return hand.hasRank(rank);
    }

    public String getName() {
        return name;
    }

    public int getBookCount() {
        return books.size();
    }

}


