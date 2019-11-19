package com.vc.hard;

import java.util.*;

class L710 {

    /** Idea is to shift the whitelisted number up and
     take the random index from 0 to whitelisted.length

     For e.g. N = 6
     blacklist = {2, 3, 4}

     1, 2, 3, 4, 5, 6
     w  b  b  b  w  w

     Only 3 whitelisted,
     so swap 2 with 5 & swap 3 with 6

     which make the arr
     1, 5, 6, 4, 2, 3
     w  w  w  b  b  b

     And then take random number from 0 - whitelisted.lenth
     */
    Random r = new Random();
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int wlen = 0;
    public L710(int N, int[] blacklist) {
        int blen = blacklist.length;
        wlen = N - blen;

        HashSet<Integer> set = new HashSet<Integer>();
        //4, 5, 6
        int from = wlen;
        while(from <= N) {
            set.add(from);
            from++;
        }
        //System.out.println(set);

        //5, 6
        for(int i = 0; i < blen; i++) {
            set.remove(blacklist[i]);
        }
        //System.out.println(set);

        //Iterator over whitelist & blacklist and map
        Iterator<Integer> itr = set.iterator();
        for(int i = 0; i < blen; i++) {
            //System.out.println("BlackList: "+blacklist[i]);
            if(blacklist[i] < wlen) {
                int e = itr.next();
                //System.out.println("BlackList: "+blacklist[i]+" WhiteListing with "+e);
                map.put(blacklist[i], e);
            }
        }
        //System.out.println(map);
    }

    public int pick() {
        int rIndex = r.nextInt(wlen);
        return map.getOrDefault(rIndex, rIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */