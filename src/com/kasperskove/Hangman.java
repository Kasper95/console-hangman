package com.kasperskove;

public class Hangman {

    public static void main(String[] args) {

        // creating Game object with the parameter (answer)
        Game game = new Game("treehouse");
        // game is passed through Prompter's constructor
        Prompter prompter = new Prompter(game);

        boolean isHit = prompter.promptForGuess();
        if (isHit) {
            System.out.println("We got a hit!");
        } else {
            System.out.println("Oops! That's a miss.");
        }
    }
}
