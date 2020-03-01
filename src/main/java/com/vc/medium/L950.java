package com.vc.medium;

import java.util.*;

class L950 {
    public int[] deckRevealedIncreasing(int[] deck) {
        if(deck == null || deck.length == 0) return new int[0];

        int n = deck.length;

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) q.offer(i);

        Arrays.sort(deck);
        int[] res = new int[n];
        int index = 0;
        while(!q.isEmpty()) {
            //Reveal
            int reveal = q.poll();
            res[reveal] = deck[index++];

            //Push to the bottom
            if(!q.isEmpty()) q.offer(q.poll());
        }
        return res;
    }
}
