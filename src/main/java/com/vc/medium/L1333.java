package com.vc.medium;

import java.util.*;

class L1333 {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] x, int[] y) {
                int rating = Integer.compare(y[1], x[1]);
                if(rating == 0) return Integer.compare(y[0], x[0]);
                else return rating;
            }
        });

        for(int[] restaurant: restaurants) {
            if(restaurant[2] >= veganFriendly
                    && restaurant[3] <= maxPrice
                    && restaurant[4] <= maxDistance)
                pq.offer(new int[]{restaurant[0], restaurant[1]});
        }

        List<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()) list.add(pq.poll()[0]);
        return list;
    }
}
