package TwitMiner;

import twitter4j.*;

import twitter4j.conf.ConfigurationBuilder;

public class SearchTweet {

    public static void main(String args[]) throws Exception {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("l6H0HBRCkTxWAjhRsfk97bWdk")
                .setOAuthConsumerSecret("mvoAw2MWXaEfww565llBStV5cofzJrUbJCQMjt4RCXeXoS4MHg")
                .setOAuthAccessToken("833975933606453250-4tpuplmCfo9fw2ma4aq3ypq2FWWwOAc")
                .setOAuthAccessTokenSecret("VzwWyodmL0Tgn21CGtEAN1baqyKsHD3boHipDTN7coEIU");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        ResponseList<twitter4j.Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing foot timeline.");
        for (twitter4j.Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());


        }
    }

}