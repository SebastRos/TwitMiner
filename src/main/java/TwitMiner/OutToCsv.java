package TwitMiner;

import java.awt.peer.SystemTrayPeer;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class OutToCsv {

    private static BufferedWriter bw = null;
    private static BufferedReader rw = null;
    private static BufferedReader rw2 = null;
    private String ligne;

    private static Map<String, Integer> stockWord = new HashMap();

    public OutToCsv() {
        try{
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("dataOut.csv")));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("result.csv")));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("map.csv"));
            stockWord = (Map<String, Integer>) ois.readObject();
            Map<Integer, String> stockWordReversed = stockWord.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

            while ((ligne = rw.readLine())!=null){
                System.out.println("On est dans le while");
                String[] parts = ligne.split(" ");
                for(int i = 0;i < parts.length-1; ++i){
                    System.out.println("On est dans le for");
                    int partKey = Integer.parseInt(parts[i]);
                    if (stockWordReversed.containsKey(partKey)) {
                        System.out.println("On est dans le if");

                        bw.write(stockWordReversed.get(partKey)+ " ");
                        System.out.println(stockWordReversed.get(partKey)+ " " +parts[parts.length-1]);

                    }

                }
                bw.write(" "+parts[parts.length-1]);
                bw.newLine();

            }

            bw.newLine();
            bw.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }




    }



    public static void main(String[] args) {
        OutToCsv test = new OutToCsv();
    }

}
