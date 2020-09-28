package com.vc.hard;

import java.util.*;

class NumberOfIslandsIi {
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();

        int[] rootArr = new int[m * n];
        int count = 0;
        Arrays.fill(rootArr, -1);
        for(int[] position: positions) {
            int x = position[0];
            int y = position[1];
            int root = x * n + y;
            if(rootArr[root] == -1) {
                count++;
                rootArr[root] = root;
                for(int[] dir: dirs) {
                    int xNew = x + dir[0];
                    int yNew = y + dir[1];
                    int rootNeighbour = xNew * n + yNew;
                    if(xNew >= 0 && xNew < m && yNew >= 0 && yNew < n && rootArr[rootNeighbour] != -1) {
                        rootNeighbour = find(rootArr, rootNeighbour);
                        if(rootArr[root] != rootNeighbour) {
                            count--;
                            rootArr[rootNeighbour] = root;
                        }
                    }
                }
            }
            res.add(count);
        }
        return res;
    }

    private int find(int[] rootArr, int root) {
        if(rootArr[root] == root) return root;
        else return find(rootArr, rootArr[root]);
    }
}