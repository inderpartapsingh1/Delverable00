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
public class Main {

    public static void main(String[] args) {

        GameUI ui = new GameUI();
        Game game = new Game();

        ui.showMessage("Enter number of players (2-5):");
        game.registerPlayers(ui);

        game.startGame();
        game.playGame(ui);
    }
}
