class Twitter {
    private class Tweet {
        int tweetId;
        int timePosted;
        public Tweet(int tId, int time){
            tweetId = tId;
            timePosted = time;
        }
    }
    
    Map<Integer, Set<Integer>> follow;
    Map<Integer, List<Tweet>> user;
    int order;
    /** Initialize your data structure here. */
    public Twitter() {
        this.user = new HashMap<>();
        this.follow = new HashMap<>();
        this.order = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        order++;
        if (!user.containsKey(userId)) {
            user.put(userId, new ArrayList<>());
            follow(userId, userId);
        }
        user.get(userId).add(0, new Tweet(tweetId, order));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>(new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t1.timePosted - t2.timePosted;
            }
        });
        Set<Integer> follower = follow.get(userId);
        if (follower == null) {
            return result;
        }
        for (Integer f : follower) {
            List<Tweet> cur = user.get(f);
            if (cur == null) {
                continue;
            }
            for (Tweet t : cur) {
                if (pq.size() < 10) {
                    pq.offer(t);
                } else {
                    if (pq.peek().timePosted > t.timePosted) {
                        break;
                    } else {
                        pq.poll();
                        pq.offer(t);
                    }
                }
            }
        }
        while (!pq.isEmpty()) {
            result.add(0, pq.poll().tweetId);
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) {
            follow.put(followerId, new HashSet<>());
        }
        follow.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId) || followerId == followeeId) {
            return;
        }
        follow.get(followerId).remove(followeeId);
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