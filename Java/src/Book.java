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

public class Book {

    private Card.Rank rank;
    private List<Card> cards = new ArrayList<>();

    public Book(Card.Rank rank) {
        this.rank = rank;
    }

    public void addCards(List<Card> cards) {
        this.cards.addAll(cards);
    }

    public Card.Rank getRank() {
        return rank;
    }
}