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

public class Hand {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        if (card != null) cards.add(card);
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public void removeCards(List<Card> cards) {
        this.cards.removeAll(cards);
    }

    public boolean hasRank(Card.Rank rank) {
        return cards.stream().anyMatch(c -> c.getRank() == rank);
    }

    public List<Card> getCardsOfRank(Card.Rank rank) {
        List<Card> result = new ArrayList<>();
        for (Card c : cards) {
            if (c.getRank() == rank) result.add(c);
        }
        return result;
    }

    public void showHand() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }
}