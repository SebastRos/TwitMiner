package TwitMiner;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CsvToTrans {

    private static ObjectOutputStream oos = null;
    private static BufferedReader rw = null;
    private static BufferedWriter bw = null;
    private static Map<String, Integer> stockWord = new HashMap();
    private static int key=1;
    private static String ligne;


    public CsvToTrans() {
        try{
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("data.csv")));
            oos = new ObjectOutputStream( new FileOutputStream("map.csv"));
            while ((ligne = rw.readLine())!=null){
                String[] parts = ligne.split(";");
                for (String word : parts){
                    if (!stockWord.containsKey(word)){
                        stockWord.put(word, key);
                        ++key;
                    }
                }
            }

            oos.writeObject(stockWord);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void remplirTrans(){
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.trans")));
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("data.csv")));
            while ((ligne = rw.readLine())!=null){
                String[] parts = ligne.split(";");
                for (String word : parts){
                    int key_word=0;

                    for (Map.Entry<String,Integer> entry : stockWord.entrySet()){
                        if (word.equals(entry.getKey()))
                            key_word=entry.getValue();
                    }

                    bw.write(key_word+ " ");

                }
                bw.newLine();
                bw.flush();


            }
            bw.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CsvToTrans test = new CsvToTrans();
        test.remplirTrans();
    }


}
