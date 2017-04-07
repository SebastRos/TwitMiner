package TwitMiner;

import java.io.*;

public class OutToCsv {

    private static BufferedWriter bw = null;
    private static BufferedReader rw = null;

    public OutToCsv() {
        try{
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("data.csv")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("map.csv")));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
