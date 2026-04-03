/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.List;

/**
 *
 * @author Inder Partap Singh
 * @author Mohan Singh
 * @author Jaskarn Singh Gill
 * @author Milandeep Singh 
 */
public class Book {
    private String rank;
    private List<Card> cards = new ArrayList<>();

    public Book(String rank) {
        this.rank = rank;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public boolean isComplete() {
        return cards.size() == 4;
    }

    public String getRank() {
        return rank;
    }

    public List<Card> getCards() {
        return cards;
    }
}
