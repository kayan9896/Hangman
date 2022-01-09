import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class implements interface Controller, ActionListener and KeyListener,
 * and represents a HangmanController
 */
public class HangmanController implements Controller, ActionListener, KeyListener {
    private Hangman h;
    private HangmanGUI view;
    private int ct;

    /**
     * Construct a HangmanController and initialize it with Hangman model and HangmanGUI
     * @param m the model of the game
     * @param v the GUI viewer of the game
     */
    public HangmanController(Hangman m, HangmanGUI v){
        h=m;
        view=v;
    }

    @Override
    public void go() {
        this.view.setQuitButtonListener();
        this.view.setListener(this,this);
        this.view.makeVisible();
    }

    @Override
    public String play(String readIn){
        if(h==null) throw new IllegalArgumentException("No model");
        StringBuilder ap = new StringBuilder();
        if(h.lose()||h.win()) ap.append("Game over. Start a new game.");
        else if(readIn.isEmpty()) ap.append(h.toString()+"\n\nGuess a character");
        else {
            String st=readIn;
            try{
                h.guess(st);
                ap.append(h.toString()+"   \n\n");
                if(h.isRight()!=0) ap.append("Correct character. ");
                else ap.append(st+" is not in the word. ");

                if (h.getChances()==1){ct=1;ap.append("\n____\n,,   I  \n");}
                if (h.getChances()==2){ct=2;ap.append("\n____\n,,   I  \n,  O  \n");}
                if (h.getChances()==3){ct=3;ap.append("\n____\n,,   I  \n,  O  \n,,  I  \n");}
                if (h.getChances()==4){ct=4;ap.append("\n____\n,,   I  \n,  O  \n, \\I  \n");}
                if (h.getChances()==5){ct=5;ap.append("\n____\n,,   I  \n,  O  \n, \\I/ \n");}
                if (h.getChances()==6){ct=6;ap.append("\n____\n,,   I  \n,  O  \n, \\I/ \n,,  I  \n");}
                if (h.getChances()==7){ct=7;ap.append("\n____\n,,   I  \n,  O  \n, \\I/ \n,,  I  \n,  /  \n");}
                if (h.getChances()==8){ct=8;ap.append("\n____\n,,   I  \n,  O  \n, \\I/ \n,,  I  \n, / \\ \n");}

                if(h.win()) {
                    ap.append("\nWin!\nStart a new game.\n");
                    return ap.toString();
                }
                if(h.lose()) {
                    ap.append("\nLose. The word is "+h.answer()+"\nStart a new game.\n");
                    return ap.toString();
                }
            }
            catch (IllegalArgumentException i){
                ap.append("Must be a single character unless you type the right word.");
            }
        }
        return ap.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String t=view.getInputText();
        String status;

        try {
            status = play(t);
            view.setEchoOutput(status);
            switch (ct) {
                case 1 -> view.setP1();
                case 2 -> view.setP2();
                case 3 -> view.setP3();
                case 4 -> view.setP4();
                case 5 -> view.setP5();
                case 6 -> view.setP6();
                case 7 -> view.setP7();
                case 8 -> view.setP8();
            }
        } catch (Exception ex) {
            view.showErrorMessage(ex.getMessage());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_ESCAPE) System.exit(0);
        if(e.getKeyCode()==KeyEvent.VK_F1) {
            try {
                String dir = System.getProperty("user.dir");
                Runtime rt = Runtime.getRuntime();
                Process p = rt.exec("java -jar "+ dir +"\\han.jar");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            String t=view.getInputText();
            String status;

            try {
                status = play(t);
                view.setEchoOutput(status);
                switch (ct) {
                    case 1 -> view.setP1();
                    case 2 -> view.setP2();
                    case 3 -> view.setP3();
                    case 4 -> view.setP4();
                    case 5 -> view.setP5();
                    case 6 -> view.setP6();
                    case 7 -> view.setP7();
                    case 8 -> view.setP8();
                }
            } catch (Exception ex) {
                view.showErrorMessage(ex.getMessage());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
