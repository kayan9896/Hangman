/**
 * This class implements HangmanModel represents the model of a Hangman game
 */
public class Hangman implements HangmanModel{
    private String s1;
    private String s2;
    private int chances;
    private int right;

    /**
     * Construct a Hangman class and initialize it with a string i
     * @param i the vocabulary of this game
     */
    public Hangman(String i){
        s1=i.toLowerCase();
        chances=0;
        s2=s1;
        s2=s2.replaceAll("[a-z]","_");
    }

    @Override
    public boolean lose(){
        return chances >= 8;
    }

    @Override
    public boolean win(){
        return !s2.contains("_");
    }

    @Override
    public void guess(String g){
        if(g.toLowerCase().equals(s1)){
            right=2;
            s2=s1;
        }else{
            if(!g.toLowerCase().matches("[a-z]")) throw new IllegalArgumentException("Must be a single character\n");
            if(!s1.contains(g.toLowerCase())) {
                chances++;
                right=0;
            }
            else{
                int i;
                for(i=0; i<s1.length(); i++){
                    if(s1.charAt(i)==g.toLowerCase().charAt(0)){
                        char[] tmp=s2.toCharArray();
                        tmp[i]=g.toLowerCase().charAt(0);
                        s2=String.valueOf(tmp);
                    }
                }
                right=1;
            }
        }
    }

    /**
     * Return the chances used in the current game
     * @return the chances used in the current game
     */
    public int getChances(){
        return chances;
    }
    @Override
    public String toString(){
        int i;
        String str ="";
        for(i=0;i<s2.length();i++){
            str+=s2.charAt(i)+" ";
        }

        return str;
    }

    /**
     * Return the correct word
     * @return the correct word
     */
    public String answer(){
        return s1;
    }

    /**
     * Return the status (win, right or wrong) of each guess
     * @return the status of each guess
     */
    public int isRight(){
        return right;
    }
}
