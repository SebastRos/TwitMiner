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
                stockUselessWord.add("\""+ligne+"\"");
            }
            for (String elt : stockUselessWord)
                System.out.println(elt);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isIn(String mot){
        for (String elt : stockUselessWord)
            if(mot.equals(elt)) return true;
        return false;

    }
    public void lireEtEnlever (){
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resultWithoutUselessWord.csv")));
            rw2 = new BufferedReader(new InputStreamReader(new FileInputStream("result.csv")));
            System.out.println("Dossier check");
            while ((ligne = rw2.readLine())!=null) {
                String[] parts = ligne.split(" ");
                Boolean isUselessWord =false;
                System.out.println("Ligne");
                for(int i = 0;i < parts.length-1; ++i){
                    if (isIn(parts[i])) {
                        System.out.println(parts[i]);
                        isUselessWord = true;
                        break;
                    }
                }
                System.out.println(isUselessWord);
                if (!isUselessWord){
                    bw.write(ligne);
                    bw.newLine();
                    bw.flush();
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DeleteUselessWord() {
        this.remplirListWord();
        this.lireEtEnlever();
    }

    public static void main(String[] args) {
        DeleteUselessWord test = new DeleteUselessWord();
    }
}
