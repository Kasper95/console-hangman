package com.kasperskove;

/**
 * Created by KASPER on 4/30/17.
 */
public class Game {

    private String answer;
    private String hits;
    private String misses;
    public static final int MAX_MISSES = 7; // using constant, max number of misses won't change

    public Game(String answer) {
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    private char normalizeGuess(char letter) {
        // ensure character is a letter
        if(! Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        // now make it lowercase to avoid silliness ;)
        letter = Character.toLowerCase(letter);
        if (misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1) {
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        return letter;
    }

    public boolean applyGuess(char letter){

        letter = normalizeGuess(letter);

        // hit if the letter is part of the answer String
        boolean isHit = answer.indexOf(letter) != -1;

        // if is hit, add that letter to the 'hits' list else +='misses' list
        if (isHit) {
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    public boolean applyGuess(String letters){
        if (letters.length() == 0) {
            throw new IllegalArgumentException("No letter found");
        }

        return applyGuess(letters.charAt(0));
    }

    public String getCurrentProgress(){
        // gets the current game progress by returning guessed/un-guessed letter
        String progress = "";
        // goes through all letters in the answer and adds hits to display
        for (char letter : answer.toCharArray()) {
            char display = '-';
            // if it's found, add to display
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            // appends displays to progress string
            progress += display;
        }
        return progress;
    }

    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }
}
