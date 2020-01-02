package com.vc.hard;

import java.util.*;

class L711 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }
    }

    static class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            int cmp = Integer.valueOf(p1.x).compareTo(p2.x);
            if(cmp == 0) return Integer.valueOf(p1.y).compareTo(p2.y);
            return cmp;
        }
    }

    public int numDistinctIslands2(int[][] grid) {
        int n = grid.length;
        if(n == 0) return 0;
        int m = grid[0].length;
        List<Point> points = new ArrayList<>();
        HashSet<String> islands = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    points.clear();
                    dfs(i, j, points, grid);
                    //System.out.println(points);
                    String str = transform(points);
                    //System.out.println(str);
                    islands.add(str);
                }
            }
        }
        return islands.size();
    }

    private int[][] transforms = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private String transform(List<Point> points) {
        TreeSet<String> res = new TreeSet<>();

        for(int[] transform: transforms) {
            List<Point> transformedX = new ArrayList<>();
            List<Point> transformedY = new ArrayList<>();
            int xTransform = transform[0];
            int yTransform = transform[1];
            for(Point point: points) {
                int x = point.x * xTransform;
                int y = point.y * yTransform;
                transformedX.add(new Point(x, y));
                transformedY.add(new Point(y, x));
            }
            Collections.sort(transformedX, new PointComparator());
            res.add(normalize(transformedX));

            Collections.sort(transformedY, new PointComparator());
            res.add(normalize(transformedY));
            //System.out.println("transformed: "+transformed+" str: "+str);
        }

        //System.out.println("points: "+points+" hashset: "+res);
        return res.iterator().next();
    }

    private String normalize(List<Point> points) {
        StringBuilder str = new StringBuilder();
        for(int i = 1; i < points.size(); i++) {
            int x = points.get(i).x - points.get(0).x;
            int y = points.get(i).y - points.get(0).y;
            str.append(x);
            str.append(":");
            str.append(y);
            str.append(":");
        }
        //System.out.println("points: "+points+" normalized: "+str.toString());
        return str.toString();
    }

    private int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};
    private void dfs(int x, int y, List<Point> points, int[][] grid) {
        if(grid[x][y] == 1) {
            grid[x][y] = -1;
            points.add(new Point(x, y));
            for(int[] dir: dirs) {
                int xNew = x + dir[0];
                int yNew = y + dir[1];
                if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                    dfs(xNew, yNew, points, grid);
                }
            }
        }
    }
}
