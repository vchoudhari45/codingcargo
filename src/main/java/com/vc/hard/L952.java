package com.vc.hard;

import java.util.*;

class L952 {
    public int largestComponentSize(int[] arr) {
        int N = arr.length;
        int[] parent = new int[N];
        for(int i = 0; i < N; i++) parent[i] = i;
        HashMap<Integer, Integer> factorToIndex = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            int element = arr[i];
            for(int j = 2; j * j <= element; j++) {
                //Add all the factor of number into
                if(element % j == 0) {
                    //Number is divisible j
                    if(factorToIndex.containsKey(j)) {
                        //Some other element already claimed that j is it's factor
                        union(i, factorToIndex.get(j), parent);
                    }
                    else {
                        factorToIndex.put(j, i);
                    }

                    //Also add the other factor
                    if(factorToIndex.containsKey(element / j)) {
                        union(i, factorToIndex.get(element / j), parent);
                    }
                    else {
                        factorToIndex.put(element / j, i);
                    }
                }
            }

            //Add number it's self because number can be one of the prime factor like 2, 3, 5 etc
            if(factorToIndex.containsKey(element)) {
                union(i, factorToIndex.get(element), parent);
            }
            else {
                factorToIndex.put(element, i);
            }
        }

        //Compress Path
        for(int i = 0; i < N; i++) {
            parent[i] = find(parent[i], parent);
        }

        //System.out.println(factorToIndex);

        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int p: parent) {
            //System.out.println(p);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        //System.out.println(map);

        for(Integer value: map.values()) max = Math.max(max, value);
        return max;
    }

    private void union(int i, int j, int[] parent) {
        int iParent = find(i, parent);
        int jParent = find(j, parent);
        if(iParent != jParent) parent[iParent] = jParent;
    }

    private int find(int i, int[] parent) {
        if(i == parent[i]) return i;
        return parent[i] = find(parent[i], parent);
    }
}