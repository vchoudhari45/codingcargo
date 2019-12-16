package com.vc.hard;

import java.util.*;

class L305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] rootArr = new int[m * n];
        Arrays.fill(rootArr, -1);
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int count = 0;
        for(int i = 0; i < positions.length; i++) {
            int px = positions[i][0];
            int py = positions[i][1];
            int root = px * n + py;
            if(rootArr[root] == -1) {
                count++;
                rootArr[root] = root;
                for(int[] dir: dirs) {
                    int xNew = px + dir[0];
                    int yNew = py + dir[1];
                    int rootNb = xNew * n + yNew;
                    if(xNew >= 0 && xNew < m && yNew >= 0 && yNew < n && rootArr[rootNb] != -1){
                        rootNb = findRoot(rootNb, rootArr);
                        if(rootNb != root) {
                            count--;
                            rootArr[rootNb] = root;
                        }
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    private int findRoot(int root, int[] rootArr) {
        if(rootArr[root] == root) return root;
        else return findRoot(rootArr[root], rootArr);
    }
}