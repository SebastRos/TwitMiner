package TwitMiner;

import twitter4j.*;

import java.io.*;
import java.lang.String;

public class SearchTweet {

    private static BufferedWriter bw = null;
    private static int i = 0;
    private static int t=0;

    public static void main(String args[]) throws Exception {
        Query query = new Query("#Presidentielle2017");

        Account account = new Account();
        Twitter twitter = account.getTwitter();

        System.out.println("Showing foot timeline.");

        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.csv")));

            while (true) {
                QueryResult queryRes = twitter.search(query);
                for (twitter4j.Status status : queryRes.getTweets()) {
                    System.out.println(status.getCreatedAt() + " - " + status.getUser().getName() + " - " + status.getUser().getLocation() + " : " +
                            status.getText().replaceAll(" ", "\";\"").replaceAll("\\s", "") + "\"\n");
                    String tweet = status.getCreatedAt() + " - " + status.getUser().getName() + " - " + status.getUser().getLocation() + " : " +
                            status.getText().replaceAll(" ", "\";\"").replaceAll("\\s", "") + "\"\n";
                    ++i;
                    ++t;
                    bw.write(tweet);
                    bw.flush();
                }
                if(!queryRes.hasNext()){
                    break;
                }

                if (t>10001){
                    break;
                }
                if (i>200){
                    System.out.print("\n"+"En pause"+"\n");
                    Thread.sleep(300000);
                    i=0;
                }
                query = queryRes.nextQuery();

            }
            System.out.println("Y a " + i + " tweet");

        } catch (FileNotFoundException e){
            System.out.println("Le fichier n'est pas trouvé ou innexistant");
            e.printStackTrace();

        }
    }

}