/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Inder Partap Singh
 * @author Mohan Singh
 * @author Jaskaran Singh Gill
 * @author Milandeep Singh
 */

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 */
import java.util.*;

public abstract class Player {

    protected String name;
    protected Hand hand = new Hand();
    protected List<Book> books = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void drawCard(Deck deck) {
        hand.addCard(deck.dealCard());
    }

    public boolean askForCard(Card.Rank rank, Player other) {
        List<Card> cards = other.hand.getCardsOfRank(rank);

        if (!cards.isEmpty()) {
            hand.addCards(cards);
            other.hand.removeCards(cards);
            return true;
        }
        return false;
    }

    public void checkForBooks() {
        for (Card.Rank rank : Card.Rank.values()) {
            List<Card> cards = hand.getCardsOfRank(rank);
            if (cards.size() == 4) {
                Book book = new Book(rank);
                book.addCards(cards);
                books.add(book);
                hand.removeCards(cards);

                System.out.println(name + " completed a book of " + rank);
            }
        }
    }

    public void showHand() {
        System.out.println(name + "'s Hand:");
        hand.showHand();
    }

    public String getName() { return name; }
    public int getBookCount() { return books.size(); }

    // ABSTRACT METHODS
    public abstract Card.Rank chooseRank(GameUI ui);
    public abstract Player chooseTarget(List<Player> players, GameUI ui);
}