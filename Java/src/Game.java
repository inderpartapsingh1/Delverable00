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

public class Game {

    private List<Player> players = new ArrayList<>();
    private Deck deck = new Deck();
    private int currentIndex = 0;

    private static final int INITIAL_CARDS = 5;

    public void registerPlayers(GameUI ui) {

        int num;
        do {
            num = ui.getIntInput();
            if (num < 2 || num > 5)
                ui.showMessage("Enter between 2 and 5 players:");
        } while (num < 2 || num > 5);

        for (int i = 0; i < num; i++) {
            String name = ui.prompt("Enter player name: ");
            players.add(new PlayerN(name));
        }
    }

    public void startGame() {
        deck.shuffle();

        for (Player p : players) {
            for (int i = 0; i < INITIAL_CARDS; i++) {
                p.drawCard(deck);
            }
        }
    }

    public void playGame(GameUI ui) {

        while (!deck.isEmpty()) {

            Player current = players.get(currentIndex);

            ui.showMessage("\n--- " + current.getName() + "'s Turn ---");
            current.showHand();

            Card.Rank rank = current.chooseRank(ui);
            Player target = current.chooseTarget(players, ui);

            boolean success = current.askForCard(rank, target);

            if (!success) {
                ui.showMessage("Go Fish!");
                current.drawCard(deck);
            }

            current.checkForBooks();
            nextPlayer();
        }

        displayWinner(ui);
    }

    private void nextPlayer() {
        currentIndex = (currentIndex + 1) % players.size();
    }

    private void displayWinner(GameUI ui) {

        Player winner = Collections.max(players, Comparator.comparingInt(Player::getBookCount));

        ui.showMessage("\nWinner: " + winner.getName());

        for (Player p : players) {
            ui.showMessage(p.getName() + ": " + p.getBookCount() + " books");
        }
    }
}