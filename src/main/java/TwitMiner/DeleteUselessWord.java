package TwitMiner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Créer par Sébastien ROSPARS le 11/04/2017.
 */
public class DeleteUselessWord {
    private static BufferedReader rw = null;
    private static BufferedReader rw2 = null;
    private static BufferedWriter bw = null;
    private static ArrayList<String> stockUselessWord = new ArrayList();
    private static String ligne;


    public void remplirListWord(){
        try {
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("motinutiles.csv")));
            while ((ligne = rw.readLine())!=null){
                stockUselessWord.add(ligne);
            }
            for (String elt : stockUselessWord)
                System.out.println(elt);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lireEtEnlever (){
        try {
            rw2 = new BufferedReader(new InputStreamReader(new FileInputStream("result.csv")));
            while ((ligne = rw.readLine())!=null) {
                String[] parts = ligne.split(" ");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DeleteUselessWord() {
        this.remplirListWord();
    }

    public static void main(String[] args) {
        DeleteUselessWord test = new DeleteUselessWord();
    }
}
