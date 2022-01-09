/**
 * A Hangman game controller that connects the viewer and model
 */
public interface Controller {
    /**
     * Run the controller
     */
    void go();
    /**
     * Execute the Hangman game using the model
     * @param s the input character
     * @return the text for game status
     */
    String play(String s);
}
