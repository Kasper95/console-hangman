package com.kasperskove;

/**
 * Created by KASPER on 4/30/17.
 */
public class Game {

    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }

    public boolean applyGuess(char letter){

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

}
