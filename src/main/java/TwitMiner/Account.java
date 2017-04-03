package TwitMiner;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class Account {
    private ConfigurationBuilder cb = null;
    private TwitterFactory tf = null;
    private Twitter twitter = null;

    public Account() {
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("l6H0HBRCkTxWAjhRsfk97bWdk")
                .setOAuthConsumerSecret("mvoAw2MWXaEfww565llBStV5cofzJrUbJCQMjt4RCXeXoS4MHg")
                .setOAuthAccessToken("833975933606453250-4tpuplmCfo9fw2ma4aq3ypq2FWWwOAc")
                .setOAuthAccessTokenSecret("VzwWyodmL0Tgn21CGtEAN1baqyKsHD3boHipDTN7coEIU");

        tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }

    public Twitter getTwitter(){
        return twitter;
    }
}
