package com.kasperskove;

public class Hangman {

    public static void main(String[] args) {

        // creating Game object with the parameter (answer)
        Game game = new Game("treehouse");
        // game is passed through Prompter's constructor
        Prompter prompter = new Prompter(game);

        while (game.getRemainingTries() > 0) {
            prompter.displayProgress();
            prompter.promptForGuess();
        }
    }
}
