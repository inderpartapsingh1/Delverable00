/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milandeep singh
 * @author jaskaran singh gill
 * @author inderpartap singh
 * @author mohan singh
 * 
 */
public class Hand {
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }

    public boolean hasRank(String rank) {
        for (Card c : cards) {
            if (c.getRank().equals(rank)) return true;
        }
        return false;
    }

    public List<Card> getCardsOfRank(String rank) {
        List<Card> matching = new ArrayList<>();
        for (Card c : cards) {
            if (c.getRank().equals(rank)) matching.add(c);
        }
        return matching;
    }

    public void showHand() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
