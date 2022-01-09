import java.io.InputStreamReader;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        String[] OxfordDic={"succeed","CANADA","Extreme","vancouver","process","finish","with","exit","code","encyclopedia","stack","eclipse","community","select","navigate","administrator","Refactor","favourite","Structure","terminal","problem","space","slash","parenthesis","thesis","plus","yawn","xenophobia","zinc","potassium","cod","salmon","platinum","equation","integral","quantum","dispersion","refraction","sprint","deluge","graphical","interface","swing","console","server","assignment","course","reindeer"};
        Random r=new Random();
        String vocab=OxfordDic[r.nextInt(OxfordDic.length)];

        new HangmanController(new Hangman(vocab),new HangmanGUI("Hangman Game")).go();
    }
}
