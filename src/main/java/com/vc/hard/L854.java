package com.vc.hard;

import java.util.*;

class L854 {
    public int kSimilarity(String source, String target) {
        if(source.equals(target)) return 0;

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        q.offer(source);
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String e = q.poll();

                //System.out.println(e);

                if(e.equals(target)) return level;

                if(visited.contains(e)) continue;

                visited.add(e);

                int needToFixIndex = 0;
                while(e.charAt(needToFixIndex) == target.charAt(needToFixIndex)) needToFixIndex++;
                for(int index = needToFixIndex + 1; index < target.length(); index++) {
                    if(e.charAt(index) == target.charAt(index) || e.charAt(index) != target.charAt(needToFixIndex)) continue;

                    String newState = swap(e, needToFixIndex, index);
                    q.offer(newState);
                }
            }
            level++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] c = str.toCharArray();
        char tmp = c[i];
        c[i] = c[j];
        c[j] = tmp;
        return new String(c);
    }
}
