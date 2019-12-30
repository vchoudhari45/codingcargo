package com.vc.hard;

import java.util.*;

class L656 {
    public List<Integer> cheapestJump(int[] arr, int B) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int[] lexi = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == -1) continue;
            for(int j = Math.max(0, i - B); j < i; j++) {
                if(arr[j] == -1) continue;
                int alt = dp[j] + arr[i];
                if(alt < dp[i] || alt == dp[i] && lexi[i] < lexi[j] + 1) {
                    dp[i] = alt;
                    prev[i] = j;
                    lexi[i] = lexi[j] + 1;
                }
            }
        }
//         System.out.println("\nArray: ");
//         for(int i = 0; i < dp.length; i++) System.out.print(dp[i]+" ");

//         System.out.println("\nPrev: ");
//         for(int i = 0; i < dp.length; i++) System.out.print(prev[i]+" ");

//         System.out.println("\nLexi: ");
//         for(int i = 0; i < dp.length; i++) System.out.print(lexi[i]+" ");

        List<Integer> q = new LinkedList<>();
        for(int i = n - 1; i >= 0; i = prev[i]) {
            q.add(0, i + 1);
        }
        if(q.get(0) != 1) q.clear();
        return q;
    }
}
