package TwitMiner;


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class CsvToTrans {

    private static BufferedWriter bw = null;
    private static BufferedReader rw = null;
    private static Map<Integer, String> stockWord = new TreeMap();
    private static int key=1;
    private static String ligne;


    public CsvToTrans() {
        try{
            rw = new BufferedReader(new InputStreamReader(new FileInputStream("data.csv")));

            while ((ligne = rw.readLine())!=null){
                String[] parts = ligne.split(";");
                for (String word : parts){
                    boolean isExisting = false;

                    for (Map.Entry<Integer,String> entry : stockWord.entrySet()){
                        if (word.equals(entry.getValue()))
                            isExisting =true;
                    }
                    if (!isExisting){
                        stockWord.put(key, word);
                        System.out.print(stockWord.get(key) + '\n');
                        ++key;
                    }
                }
            }

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

                    for (Map.Entry<Integer,String> entry : stockWord.entrySet()){
                        if (word.equals(entry.getValue()))
                            key_word=entry.getKey();
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

    public static Map<Integer, String> getStockWord() {
        return stockWord;
    }

    public static void main(String[] args) {
        CsvToTrans test = new CsvToTrans();
        System.out.print("Le char 24 est : "+test.getStockWord().get(24));
        test.remplirTrans();
    }


}
