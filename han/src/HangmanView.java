import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

public interface HangmanView {
    /**
     * Set the display text of the game
     * @param s the string needed to be displayed from the controller
     */
    void setEchoOutput(String s);
    /**
     * Set the action listener for the button and key in the game
     * @param actionEvent the click event
     * @param key the key event
     */
    void setListener(ActionListener actionEvent, KeyListener key);
    /**
     * Get the input text of the player
     * @return the string of the input
     */
    String getInputText();
}
