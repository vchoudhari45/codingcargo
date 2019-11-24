package com.vc.hard;

import java.util.*;

class L952 {
    public int largestComponentSize(int[] arr) {
        int[] index = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            index[i] = i;
        }

        HashMap<Integer, Integer> primeFactorMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length; i++) {
            int from = arr[i];
            for(int j = 2; j * j <= from; j++) {
                if(from % j == 0) {
                    if(!primeFactorMap.containsKey(j)) {
                        primeFactorMap.put(j, i);
                    }
                    else {
                        int to = primeFactorMap.get(j);
                        int fromParent = find(i, index);
                        int toParent = find(to, index);
                        union(fromParent, toParent, index);
                    }

                    if(!primeFactorMap.containsKey(from / j)) {
                        primeFactorMap.put(from / j, i);
                    }
                    else {
                        int to = primeFactorMap.get(from / j);
                        int fromParent = find(i, index);
                        int toParent = find(to, index);
                        union(fromParent, toParent, index);
                    }
                }
            }
            if(!primeFactorMap.containsKey(from)) {
                primeFactorMap.put(from, i);
            }
            else {
                int to = primeFactorMap.get(from);
                int fromParent = find(i, index);
                int toParent = find(to, index);
                union(fromParent, toParent, index);
            }
        }

        //Compress Path
        for(int k = 0; k < arr.length; k++) {
            index[k] = find(index[k], index);
            System.out.print(index[k]+" ");
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int k = 0; k < arr.length; k++) {
            map.put(index[k], map.getOrDefault(index[k], 0) + 1);
        }

        int res = 0;
        for(Integer i: map.keySet()) {
            if(map.get(i) > res) res = map.get(i);
        }
        return res;
    }

    private int find(int x, int[] arr) {
        if(arr[x] == x) return x;
        else return find(arr[x], arr);
    }

    private void union(int x, int y, int[] arr) {
        arr[x] = y;
    }
}
