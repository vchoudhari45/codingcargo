package com.vc.hard;

import java.util.*;

class L499 {
    static class Point {
        int x;
        int y;
        int distance;
        String path;

        Point(int x, int y, int distance, String path) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.path = path;
        }
    }

    static class PointComparator implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            int cmp = Integer.valueOf(p1.distance).compareTo(p2.distance);
            if(cmp == 0) return p1.path.compareTo(p2.path);
            return cmp;
        }
    }

    int[][] dirs = {{0, 1},{0, -1},{-1, 0},{1, 0}};
    String[] paths = {"r","l","u","d"};
    private Point move(int[][] maze,
                       Point p, int dirX, int dirY, int n, int m, String path,
                       int targetX, int targetY) {
        int res = 0;
        int x = p.x;
        int y = p.y;

        while(
                x + dirX >= 0 && x + dirX < n &&
                        y + dirY >= 0 && y + dirY < m &&
                        maze[x + dirX][y + dirY] != 1 &&
                        !(x + dirX == targetX && y + dirY == targetY)
        ) {
            x = x + dirX;
            y = y + dirY;
            res++;
        }

        if(x + dirX == targetX && y + dirY == targetY)
            return new Point(x + dirX, y + dirY, p.distance + res + 1, p.path + path);
        else
            return new Point(x, y, p.distance + res, p.path + path);
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int targetX = hole[0];
        int targetY = hole[1];

        int n = maze.length;
        if(n == 0) return "";
        int m = maze[0].length;

        PriorityQueue<Point> pq = new PriorityQueue<>(new PointComparator());
        pq.offer(new Point(ball[0], ball[1], 0, ""));
        HashSet<String> visited = new HashSet<>();

        while(!pq.isEmpty()) {
            Point e = pq.poll();
            if(e.x == targetX && e.y == targetY) return e.path;
            if(!visited.contains(e.x+"=>"+e.y)) {
                visited.add(e.x+"=>"+e.y);
                //System.out.println("x: "+e.x+" y: "+e.y);
                for(int i = 0; i < dirs.length; i++) {
                    Point newPoint = move(maze, e, dirs[i][0],
                            dirs[i][1], n, m, paths[i], targetX, targetY);
                    if(!visited.contains(newPoint.x+"=>"+newPoint.y)) pq.offer(newPoint);
                }
            }
        }
        return "impossible";
    }
}