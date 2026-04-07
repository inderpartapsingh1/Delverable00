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

public class PlayerN extends Player {

    public PlayerN(String name) {
        super(name);
    }

    @Override
    public Card.Rank chooseRank(GameUI ui) {
        while (true) {
            String input = ui.prompt(name + ", choose a rank: ");
            try {
                Card.Rank rank = Card.Rank.valueOf(input.toUpperCase());

                if (hand.hasRank(rank)) return rank;

                ui.showMessage("You must have that rank!");
            } catch (Exception e) {
                ui.showMessage("Invalid rank.");
            }
        }
    }

    @Override
    public Player chooseTarget(List<Player> players, GameUI ui) {

        while (true) {
            ui.showMessage("Choose a player:");

            for (int i = 0; i < players.size(); i++) {
                if (players.get(i) != this) {
                    ui.showMessage(i + ": " + players.get(i).getName());
                }
            }

            int choice = ui.getIntInput();

            if (choice >= 0 && choice < players.size() && players.get(choice) != this) {
                return players.get(choice);
            }

            ui.showMessage("Invalid choice.");
        }
    }
}
