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
import java.util.Collections;
import java.util.List;



/** 
  * A concrete class that represents any grouping of cards for a Game. might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 */
public class Deck {
    
    private List<Card> cards = new ArrayList<>();

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card dealCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        }
        return null;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

}

    

