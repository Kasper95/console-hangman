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

        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptableCharacter = false;

        do {
            System.out.print("Enter a letter:  ");
            String guessInput = scanner.nextLine();
            // getting char from String guessInput
            // checking if guess matches or not using applyGuess method from Game class
            // that is not the Prompter's job, it's the Game's job. applyGuess returns a boolean (good to go!)
            try {
                isHit = game.applyGuess(guessInput);
                isAcceptableCharacter = true;
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s.  Please try again. %n", iae.getMessage());
            }
        } while (! isAcceptableCharacter);
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries remaining...", game.getRemainingTries());
        System.out.printf("Try to solve: %s%n", game.getCurrentProgress());
    }
}