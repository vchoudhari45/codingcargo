package com.vc.hard;

import java.util.*;

class L943 {
    //https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem
    public String shortestSuperstring(String[] arr) {
        int n = arr.length;
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                graph[i][j] = calc(arr[i], arr[j]);
                graph[j][i] = calc(arr[j], arr[i]);
            }
        }

        int dp[][] = new int[1 << n][n];
        int path[][] = new int[1 << n][n];
        int min = Integer.MAX_VALUE;
        int last = -1;
        for(int i = 0; i < (1 << n); i++) { //foreach state
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for(int j = 0; j < n; j++) {  //calculate how this state can be reached from each node
                if((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);
                    if(prev == 0) {
                        dp[i][j] = arr[j].length();
                    } else {
                        for(int k = 0; k < n; k++) {
                            if(dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if(i == (1 << n) - 1 && min > dp[i][j]) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }

        Stack<Integer> st = new Stack<Integer>();
        int cur = (1 << n) - 1;
        while(cur > 0) {
            st.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }

        StringBuilder str = new StringBuilder();
        int i = st.pop();
        str.append(arr[i]);
        while(!st.isEmpty()) {
            int j = st.pop();
            str.append(arr[j].substring(arr[j].length() - graph[i][j]));
            i = j;
        }
        return str.toString();
    }

    private int calc(String a, String b) {
        for(int i = 0; i < a.length(); i++) {
            //gcta ctaagt
            //alex lex
            if(b.startsWith(a.substring(i))) return b.length() - a.length() + i;
        }
        return b.length();
    }
}