package com.vc.hard;

import java.util.*;

class RankTransformOfAMatrix {
    public int[][] matrixRankTransform(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new int[0][0];

        int n = matrix.length;
        int m = matrix[0].length;

        //Add same value in a same group
        TreeMap<Integer, List<int[]>> treeMap = new TreeMap<>();
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                List<int[]> list = treeMap.getOrDefault(matrix[row][col], new ArrayList<>());
                list.add(new int[]{row, col});
                treeMap.put(matrix[row][col], list);
            }
        }

        int[] minX = new int[n];
        int[] minY = new int[m];
        int[][] rankMatrix = new int[n][m];
        for(Map.Entry<Integer, List<int[]>> sameValueEntry: treeMap.entrySet()) {
            ArrayList<int[]> sameValueGroup = new ArrayList<>(sameValueEntry.getValue());

            //Create union and find data structure
            int[] parent = new int[sameValueGroup.size()];
            for(int i = 0; i < parent.length; i++) parent[i] = i;

            //sameValueGroup values should be grouped by same column and same row
            HashMap<Integer, List<Integer>> xMap = new HashMap<>();
            HashMap<Integer, List<Integer>> yMap = new HashMap<>();
            for(int i = 0; i < sameValueGroup.size(); i++) {
                int[] point = sameValueGroup.get(i);
                List<Integer> xList = xMap.getOrDefault(point[0], new ArrayList<>());
                List<Integer> yList = yMap.getOrDefault(point[1], new ArrayList<>());

                xList.add(i);
                yList.add(i);
                xMap.put(point[0], xList);
                yMap.put(point[1], yList);
            }

            for(Map.Entry<Integer, List<Integer>> xEntrySet: xMap.entrySet()) {
                List<Integer> xList = xEntrySet.getValue();
                for(int i = 1; i < xList.size(); i++) {
                    union(xList.get(i - 1), xList.get(i), parent);
                }
            }

            for(Map.Entry<Integer, List<Integer>> yEntrySet: yMap.entrySet()) {
                List<Integer> yList = yEntrySet.getValue();
                for(int i = 1; i < yList.size(); i++) {
                    union(yList.get(i - 1), yList.get(i), parent);
                }
            }

            //Group them in HashMap so that they can be iterated
            HashMap<Integer, List<int[]>> sameRowColGroup = new HashMap<>();
            for(int i = 0; i < parent.length; i++) {
                int group = find(i, parent);
                List<int[]> list = sameRowColGroup.getOrDefault(group, new ArrayList<>());
                list.add(sameValueGroup.get(i));
                sameRowColGroup.put(group, list);
            }

            for(Map.Entry<Integer, List<int[]>> sameRowColEntry: sameRowColGroup.entrySet()) {
                int rank = 0;
                List<int[]> sameRowColValue = sameRowColEntry.getValue();

                for(int[] point: sameRowColValue) {
                    rank = Math.max(rank, minX[point[0]]);
                    rank = Math.max(rank, minY[point[1]]);
                }

                for(int[] point: sameRowColValue) {
                    rankMatrix[point[0]][point[1]] = rank + 1;
                    minX[point[0]] = rank + 1;
                    minY[point[1]] = rank + 1;
                }
            }
        }
        return rankMatrix;
    }

    private void union(int x, int y, int[] parent) {
        int xParent = find(x, parent);
        int yParent = find(y, parent);
        parent[yParent] = xParent;
    }

    private int find(int x, int[] parent) {
        if(parent[x] == x) return x;
        else {
            parent[x] = find(parent[x], parent);
            return parent[x];
        }
    }
}
