/**
 * A Hangman game in which a player have 8 chances to guess all characters of a provided phrase.
 */
public interface HangmanModel {
    /**
     * Execute the input to run the game
     * @param g the input guess character
     * @throws IllegalArgumentException if the input is illegal
     */
    void guess(String g);

    /**
     * Return true if the player loses. The player loses when the chances reach 8 or more.
     * @return true if the player loses, false otherwise
     */
    boolean lose();

    /**
     * Return true if the player wins. The player wins when
     * there is no dash left in the displayed string
     * @return true if the player wins, false otherwise
     */
    boolean win();
}
