package com.vc.hard;

import java.util.*;

class NumberOfDistinctIslandsIi {
    public int numDistinctIslands2(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        if(m == 0) return 0;

        List<int[]> points = new ArrayList<>();
        HashSet<String> islands = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    points.clear();
                    dfs(i, j, points, grid);
                    String island = transform(points);
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void dfs(int row, int col, List<int[]> points, int[][] grid) {
        if(grid[row][col] == 0) return;

        points.add(new int[]{row, col});
        grid[row][col] = 0;
        for(int[] dir: dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
                dfs(newRow, newCol, points, grid);
            }
        }
    }

    private Comparator<int[]> pointComparator = new Comparator<int[]>(){
        public int compare(int[] x, int [] y) {
            int cmp = Integer.compare(x[0], y[0]);
            if(cmp == 0) return Integer.compare(x[1], y[1]);
            else return cmp;
        }
    };

    private int[][] transforms = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    private String transform(List<int[]> points) {
        TreeSet<String> res = new TreeSet<>();
        for(int[] transform: transforms) {
            List<int[]> transformSame = new ArrayList<>();
            List<int[]> transformReverse = new ArrayList<>();
            for(int[] point: points) {
                int newRow = point[0] * transform[0];
                int newCol = point[1] * transform[1];

                transformSame.add(new int[]{newRow, newCol});
                transformReverse.add(new int[]{newCol, newRow});
            }

            transformSame.sort(pointComparator);
            res.add(normalize(transformSame));

            transformReverse.sort(pointComparator);
            res.add(normalize(transformReverse));
        }
        return res.iterator().next();
    }

    private String normalize(List<int[]> sortedPoints) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < sortedPoints.size(); i++) {
            int x = sortedPoints.get(i)[0] - sortedPoints.get(0)[0];
            int y = sortedPoints.get(i)[1] - sortedPoints.get(0)[1];

            sb.append(x);
            sb.append(":");
            sb.append(y);
            sb.append(":");
        }
        return sb.toString();
    }
}