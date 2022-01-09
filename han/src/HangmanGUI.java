import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

/**
 * This class extends JFrame and represents a HangmanGUI
 */
public class HangmanGUI extends JFrame implements HangmanView {
    private JPanel mainPanel;
    private JTextField input;
    private JLabel display;
    private JButton okButton;
    private JButton quitButton;
    private JLabel icon;
    private JButton restartButton;

    private ImageIcon p1=new ImageIcon("1.png");
    private ImageIcon p2=new ImageIcon("2.png");
    private ImageIcon p3=new ImageIcon("3.png");
    private ImageIcon p4=new ImageIcon("4.png");
    private ImageIcon p5=new ImageIcon("5.png");
    private ImageIcon p6=new ImageIcon("6.png");
    private ImageIcon p7=new ImageIcon("7.png");
    private ImageIcon p8=new ImageIcon("8.png");

    /**
     * Construct a HangmanGUI and initialize it with a title
     * @param title the title of the viewer
     */
    public HangmanGUI(String title){
        super(title);
        setSize(2500, 2300);
        setLocation(200, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();

        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                try {
                    String dir = System.getProperty("user.dir");
                    Runtime rt = Runtime.getRuntime();
                    Process p = rt.exec("java -jar "+ dir +"\\han.jar");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    public void makeVisible() {
        this.setVisible(true);
    }

    /**
     * Set the image for the game status
     */
    public void setP1(){
        icon.setIcon(p1);
    }
    public void setP2(){
        icon.setIcon(p2);
    }
    public void setP3(){
        icon.setIcon(p3);
    }
    public void setP4(){
        icon.setIcon(p4);
    }
    public void setP5(){
        icon.setIcon(p5);
    }
    public void setP6(){
        icon.setIcon(p6);
    }
    public void setP7(){
        icon.setIcon(p7);
    }
    public void setP8(){
        icon.setIcon(p8);
    }

    @Override
    public void setEchoOutput(String s) {
        s=s.replaceAll(",","&nbsp;");
        display.setText("<html>" + s.replaceAll("\n", "<br/<p style='margin-top:-6.5'>") + "</html>");
    }

    /**
     * Set the quit button to exit the game
     */
    public void setQuitButtonListener(){
        quitButton.addActionListener(e->{System.exit(0);});
    }

    @Override
    public void setListener(ActionListener actionEvent, KeyListener key) {
        input.addKeyListener(key);
        okButton.addActionListener(actionEvent);
    }

    @Override
    public String getInputText() {
        String t = this.input.getText();
        this.input.setText("");
        return t;
    }

    /**
     * Show the error message
     * @param error
     */
    public void showErrorMessage(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
