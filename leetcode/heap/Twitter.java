import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
public class Twitter {


    private class Tweet implements Comparable <Tweet> {
        int tweetId ;
        int userId;
        int timeStamp ;

        public Tweet(int tweetId,int userId,int timeStamp){
            this.tweetId=tweetId;
            this.userId=userId;
            this.timeStamp=timeStamp;
        }

        @Override
        public int compareTo(Tweet obj){
            return this.timeStamp- obj.timeStamp;
        }
    }


    HashMap<Integer,  List<Tweet> > tweetList ;
    HashMap<Integer, List<Integer>> followList;
    int timeStamp;

    /** Initialize your data structure here. */
    public Twitter() {
        this.tweetList= new HashMap<>();
        this.followList = new HashMap<>();
        this.timeStamp=0;
    }
    

    public void intializeUser(int userId){
        List<Integer> f = new ArrayList<>();
        f.add(userId);
        followList.put(userId, f);
        List<Tweet> list = new ArrayList<>();
        tweetList.put(userId, list);
    }


    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet tweet  =new Tweet(tweetId, userId,this.timeStamp);
        this.timeStamp++;
        // if a fresh user is seen 
        if(!followList.containsKey(userId))
        { intializeUser(userId);
        }
        tweetList.get(userId).add(tweet);
        
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Tweet> q = new PriorityQueue<>();

        if(followList.containsKey(userId)){

            for(Integer x : followList.get(userId) ){
                for(Tweet t : tweetList.get(x) ){
                    q.add(t);
                    if(q.size()>10) q.poll();
                }
            }
        }

        while(!q.isEmpty()){
          ans.add(q.poll().tweetId);
        }

        Collections.reverse(ans);
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followList.containsKey(followeeId)) intializeUser(followeeId);
        if(!followList.containsKey(followerId)) intializeUser(followerId);

        if(!followList.get(followerId).contains(followeeId)) followList.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followeeId==followerId) return ;

        
        if(  followList.containsKey(followerId) && followList.get(followerId).contains(followeeId)){
            followList.get(followerId).remove(new Integer(followeeId));
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */