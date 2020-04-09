public class TwitterClient{
    public static void main(String[] args) {
        Twitter t = new Twitter();
        t.postTweet(1, 5);
        t.unfollow(1, 1);
        System.out.println(t.getNewsFeed(1));
       


    }
}