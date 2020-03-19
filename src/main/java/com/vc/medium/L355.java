package com.vc.medium;

import java.util.*;

class Twitter {

    static class Tweet {
        int tweetId;
        int time;
        Tweet next;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Tweet("+tweetId+", "+time+")";
        }
    }

    static class User {
        int userId;
        Tweet headTweet;
        Set<User> following;

        User(int userId) {
            this.userId = userId;
            following = new HashSet<>();
        }

        @Override
        public String toString() {
            return "User("+userId+", "+headTweet+", "+following+")";
        }
    }

    private HashMap<Integer, User> users;
    private int time = 0;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)) users.put(userId, new User(userId));

        User user = users.get(userId);
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.next = user.headTweet;
        user.headTweet = tweet;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        //System.out.println(users);
        if(!users.containsKey(userId)) users.put(userId, new User(userId));

        //Merge K Sorted Tweets
        PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2) {
                return Integer.compare(t2.time, t1.time);
            }
        });

        User user = users.get(userId);
        if(user.headTweet != null) pq.offer(user.headTweet);
        for(User following: user.following) {
            if(following.headTweet != null) pq.offer(following.headTweet);
        }

        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            if(res.size() == 10) break;
            if(tweet.next != null) pq.offer(tweet.next);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!users.containsKey(followerId)) users.put(followerId, new User(followerId));
        if(!users.containsKey(followeeId)) users.put(followeeId, new User(followeeId));

        users.get(followerId).following.add(users.get(followeeId));
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(!users.containsKey(followerId)) users.put(followerId, new User(followerId));
        if(!users.containsKey(followeeId)) users.put(followeeId, new User(followeeId));

        users.get(followerId).following.remove(users.get(followeeId));
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
