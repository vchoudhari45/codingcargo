package com.vc.medium;

import java.util.*;

class L1079 {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        boolean[] visited = new boolean[tiles.length()];
        return solve(arr, visited);
    }

    private int solve(char[] arr, boolean[] visited) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;
            if(i > 0 && arr[i - 1] == arr[i] && !visited[i - 1]) continue;

            sum++;
            visited[i] = true;
            sum += solve(arr, visited);
            visited[i] = false;
        }
        return sum;
    }
}