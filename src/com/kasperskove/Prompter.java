package com.kasperskove;

import java.util.Scanner;

/**
 * Created by KASPER on 4/30/17.
 */
public class Prompter {

    // instance of Game so prompter knows about it
    private Game game;

    public Prompter (Game game){
        this.game = game;
    }

    public boolean promptForGuess(){
        // initializing scanner for console input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter:  ");
        String guessInput = scanner.nextLine();
        // getting char from String guessInput
        char guess = guessInput.charAt(0);
        // checking if guess matches or not using applyGuess method from Game class
        // that is not the Prompter's job, it's the Game's job. applyGuess returns a boolean (good to go!)
        return game.applyGuess(guess);
    }
}
