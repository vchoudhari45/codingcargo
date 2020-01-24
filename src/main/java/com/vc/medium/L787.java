package com.vc.medium;

import java.util.*;

class L787 {
    static class State {
        int city = 0;
        int price = 0;
        int remaining = 0;

        State(int city, int price, int remaining) {
            this.city = city;
            this.price = price;
            this.remaining = remaining;
        }

        @Override
        public String toString() {
            return "city: "+city+" price: "+price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>(){
            public int compare(State s1, State s2) {
                return Integer.compare(s1.price, s2.price);
            }
        });
        HashMap<Integer, List<State>> map = new HashMap<>();

        for(int[] flight: flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            State state = new State(to, price, 0);
            List<State> toList = map.getOrDefault(from, new ArrayList<State>());
            toList.add(state);
            map.put(from, toList);
        }

        pq.offer(new State(src, 0, K));
        while(!pq.isEmpty()) {
            State e = pq.poll();
            //System.out.println(e);
            if(e.city == dst) return e.price;

            if(e.remaining < 0) continue;

            for(State to: map.getOrDefault(e.city, new ArrayList<State>())) {
                pq.offer(new State(to.city, to.price + e.price, e.remaining - 1));
            }
        }
        return -1;
    }
}
