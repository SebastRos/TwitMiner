package TwitMiner;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.*;
import java.lang.String;

public class SearchTweet {

    private static BufferedWriter bw = null;

    public static void main(String args[]) throws Exception {
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("data.csv")));
            Query query = new Query("#Presidentielle2017");

            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("l6H0HBRCkTxWAjhRsfk97bWdk")
                    .setOAuthConsumerSecret("mvoAw2MWXaEfww565llBStV5cofzJrUbJCQMjt4RCXeXoS4MHg")
                    .setOAuthAccessToken("833975933606453250-4tpuplmCfo9fw2ma4aq3ypq2FWWwOAc")
                    .setOAuthAccessTokenSecret("VzwWyodmL0Tgn21CGtEAN1baqyKsHD3boHipDTN7coEIU");

            TwitterFactory tf = new TwitterFactory(cb.build());
            Twitter twitter = tf.getInstance();

            QueryResult soumsoum=twitter.search(query);

            System.out.println("Showing foot timeline.");

            for (twitter4j.Status status : soumsoum.getTweets()) {
                System.out.println(status.getCreatedAt() + " - " + status.getUser().getName() + " - " + status.getUser().getLocation() + " : " +
                        status.getText());
                String tweet = status.getCreatedAt() + " - " + status.getUser().getName() + " - " + status.getUser().getLocation() + " : " +
                        status.getText();
                bw.write(tweet);
                bw.newLine();
                bw.flush();


            }
            bw.close();

        } catch (FileNotFoundException e){
            System.out.println("Le fichier n'est pas trouvé ou innexistant");
            e.printStackTrace();

        }
    }

}