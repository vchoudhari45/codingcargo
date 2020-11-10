package com.vc.hard;

import java.util.*;

class RandomPickWithBlacklist {
    /**
         Idea is to shift the whitelisted number up and
         take the random index from 0 to whitelisted.length

         For e.g. N = 6
         blacklist = {2, 3, 4}

         1, 2, 3, 4, 5, 6
         w  b  b  b  w  w

         Only 3 whitelisted,
         so swap 2 with 5 & swap 3 with 6

         Which make the arr
         1, 5, 6, 4, 2, 3
         w  w  w  b  b  b

         And then take random number from 0 - whitelisted.length
    */
    private Random random = new Random();
    private HashMap<Integer, Integer> blacklistedMapping = new HashMap<>();
    private int blen = 0;
    private int wlen = 0;
    public RandomPickWithBlacklist(int N, int[] blacklist) {
        this.blen = blacklist.length;
        this.wlen = N - blen;

        HashSet<Integer> set = new HashSet<>();
        for(int i = wlen; i <= N; i++) set.add(i);

        for(int blacklisted: blacklist) set.remove(blacklisted);

        //Map blacklisted Indexes to One of the Whitelisted Indexes
        Iterator<Integer> itr = set.iterator();
        for(int i = 0; i < blen; i++) {
            if(blacklist[i] < wlen) {
                blacklistedMapping.put(blacklist[i], itr.next());
            }
        }
    }

    public int pick() {
        int rIndex = random.nextInt(wlen);
        return blacklistedMapping.getOrDefault(rIndex, rIndex);
    }
}

/**
 * Your RandomPickWithBlacklist object will be instantiated and called as such:
 * RandomPickWithBlacklist obj = new RandomPickWithBlacklist(N, blacklist);
 * int param_1 = obj.pick();
 */