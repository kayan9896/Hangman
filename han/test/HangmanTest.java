import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A JUnit test for the Hangman model
 */
public class HangmanTest {
    private Hangman a;

    @Before
    public void setup(){
        a=new Hangman("loog");
    }

    /**
     * Test the guess method
     */
    @Test
    public void testGuess(){
        a.guess("g");
        assertEquals(0,a.getChances());
        assertEquals("_ _ _ g ",a.toString());
        a.guess("O");
        assertEquals("_ o o g ",a.toString());
        a.guess("o");
        assertEquals("_ o o g ",a.toString());
        assertEquals(false,a.win());
    }

    /**
     * Test the lose method
     */
    public void testLose(){
        a.guess("a");
        a.guess("b");
        a.guess("c");
        a.guess("d");
        a.guess("a");
        a.guess("b");
        a.guess("c");
        a.guess("d");
        assertTrue(a.lose());
    }
    /**
     * Test the win method
     */
    @Test
    public void testWin(){
        a.guess("l");
        a.guess("O");
        a.guess("o");
        a.guess("g");
        assertTrue(a.win());
    }

    /**
     * Test the getChances method
     */
    @Test
    public void testChance(){
        assertEquals(0,a.getChances());
        a.guess("v");
        assertEquals(1,a.getChances());
    }
    /**
     * Test the toString method
     */
    @Test
    public void testToString(){
        assertEquals("_ _ _ _ ",a.toString());
    }

    /**
     * Test the answer method
     */
    @Test
    public void testAnswer(){
        assertEquals("loog",a.answer());
    }
}
