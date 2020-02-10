package com.vc.hard;

import java.util.HashMap;

class L982 {
//    Solution is not that scalable
//    public int countTriplets(int[] arr) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr.length; j++) {
//                int value = arr[i] & arr[j];
//                map.put(value, map.getOrDefault(value, 0) + 1);
//            }
//        }
//
//        int res = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for(Integer key: map.keySet()) {
//                if((key & arr[i]) == 0) {
//                    res += map.get(key);
//                }
//            }
//        }
//        return res;
//    }

    public int countTriplets(int[] arr) {
        int N = 1 << 16, M = 3;
        int[][] dp = new int[M + 1][N + 1];
        dp[0][N - 1] = 1;

        for(int number = 0; number < M; number++) {
            for(int state = 0; state < N; state++) {
                for(int a: arr) {
                    dp[number + 1][state & a] += dp[number][state];
                }
            }
        }
        return dp[M][0];
    }
}
