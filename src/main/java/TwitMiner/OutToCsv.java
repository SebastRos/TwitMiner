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
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("dataOut.csv")));
            rw2 = new BufferedReader(new InputStreamReader(new FileInputStream("map.csv")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.csv")));

            while ((ligne = rw.readLine())!=null){
                String[] parts = ligne.split(" ");
                for(int i = 0;i < parts.length-1; ++i){

                    String word="";
                    String def;
                    while ((def = rw2.readLine())!=null){
                        String[] definition = def.split(",");
                        if (parts[i].equals(definition[0])) {
                            word = definition[1];
                        }
                    }
                    bw.write(word+ " ");

                }
                bw.newLine();
                bw.flush();
            }




        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        OutToCsv test = new OutToCsv();
    }

}
