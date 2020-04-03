package com.vc.medium;

import java.util.*;

class L332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new LinkedList<>();

        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket: tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            PriorityQueue<String> pq = map.getOrDefault(from, new PriorityQueue<>(new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.compareTo(s2);
                }
            }));
            pq.offer(to);

            map.put(from, pq);
        }

        /**

             Step 1:
                 JFK -> ATL, SFO
                 SFO -> ATL
                 ATL -> JFK, SFO

                 JFK

             Step 2:
                 JFK -> SFO
                 SFO -> ATL
                 ATL -> JFK, SFO


                 ATL
                 JFK

             Step 3:
                 JFK -> SFO
                 SFO -> ATL
                 ATL -> SFO


                 JFK
                 ATL
                 JFK

             Step 4:
                 JFK ->
                 SFO -> ATL
                 ATL -> SFO


                 SFO
                 JFK
                 ATL
                 JFK

             Step 5:
                 JFK ->
                 SFO ->
                 ATL -> SFO


                 ATL
                 SFO
                 JFK
                 ATL
                 JFK

             Step 6:
                 JFK ->
                 SFO ->
                 ATL ->


                 SFO
                 ATL
                 SFO
                 JFK
                 ATL
                 JFK

             Step 7:

                 res : SFO

                 ATL
                 SFO
                 JFK
                 ATL
                 JFK

             Step 8:

                 res : ATL SFO

                 SFO
                 JFK
                 ATL
                 JFK

             Step 9, 10, 11, 12:

                res : JFK ATL JFK SFO ATL SFO
         */
        Stack<String> st = new Stack<>();
        st.push("JFK");
        while(!st.isEmpty()) {
            String airport = st.peek();

            if(map.containsKey(airport) && map.get(airport).size() > 0) {
                st.push(map.get(airport).poll());
            }
            else {
                res.add(0, airport);
                st.pop();
            }
        }
        return res;
    }
}