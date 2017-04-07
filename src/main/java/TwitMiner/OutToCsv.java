package TwitMiner;

import java.io.*;
import java.util.Map;

public class OutToCsv {

    private static BufferedWriter bw = null;
    private static BufferedReader rw = null;
    private static BufferedReader rw2 = null;
    private String ligne;


    public OutToCsv() {
        try{
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("data.out")));
            rw2 = new BufferedReader(new InputStreamReader(new FileInputStream("map.csv")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.csv")));

            while ((ligne = rw.readLine())!=null){
                String[] parts = ligne.split(" ");
                
            }




        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
