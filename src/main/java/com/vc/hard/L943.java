package com.vc.hard;

import java.util.*;

class L943 {
    public String shortestSuperstring(String[] arr) {
        //https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem
        int n = arr.length;
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                graph[i][j] = calc(arr[i], arr[j]);
                graph[j][i] = calc(arr[j], arr[i]);
            }
        }

        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int min = Integer.MAX_VALUE;
        int last = -1;
        for(int to = 0; to < (1 << n); to++) { //for each state
            Arrays.fill(dp[to], Integer.MAX_VALUE);
            for(int from = 0; from < n; from++) {
                if((to & (1 << from)) > 0) { //if ith state has jth Node?, if yes see how it can be reached
                    int prev = to - (1 << from);
                    if(prev == 0) {
                        dp[to][from] = arr[from].length();
                    }
                    else {
                        for(int via = 0; via < n; via++) {
                            if(dp[prev][via] != Integer.MAX_VALUE
                                    && dp[prev][via] + graph[via][from] < dp[to][from]) {
                                dp[to][from] = dp[prev][via] + graph[via][from];
                                path[to][from] = via;
                            }
                        }
                    }
                }
                if(to == (1 << n) - 1 && min > dp[to][from]) {
                    min = dp[to][from];
                    last = from;
                }
            }
        }

        Stack<Integer> st = new Stack<>();
        int current = (1 << n) - 1;
        while(current > 0) {
            st.push(last);
            int next = current;
            current -= (1 << last);
            last = path[next][last];
        }

        StringBuilder sb = new StringBuilder();
        int from = st.pop();
        sb.append(arr[from]);
        while(!st.isEmpty()) {
            int to = st.pop();
            sb.append(arr[to].substring(arr[to].length() - graph[from][to]));
            from = to;
        }
        return sb.toString();
    }

    private int calc(String a, String b) {
        //abcd bcde
        for(int i = 0; i < a.length(); i++) {
            if(b.startsWith(a.substring(i))) return b.length() - a.length() + i;
        }
        return b.length();
    }
}