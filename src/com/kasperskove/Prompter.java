package com.kasperskove;

import java.util.Scanner;

/**
 * Created by KASPER on 4/30/17.
 */

public class Prompter {

    // instance of Game so prompter knows about it
    private Game game;

    public Prompter (Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        // initializing scanner for console input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter:  ");
        String guessInput = scanner.nextLine();
        // getting char from String guessInput
        char guess = guessInput.charAt(0);
        // checking if guess matches or not using applyGuess method from Game class
        // that is not the Prompter's job, it's the Game's job. applyGuess returns a boolean (good to go!)
        boolean isHit = false;
        try { isHit = game.applyGuess(guess);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries remaining...", game.getRemainingTries());
        System.out.printf("Try to solve: %s%n", game.getCurrentProgress());
    }
}