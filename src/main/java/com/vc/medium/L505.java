package com.vc.medium;

import java.util.*;

class L505 {

    static class Point {
        int x;
        int y;
        int distance = 0;

        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance =distance;
        }

        @Override
        public String toString() {
            return "x: "+x+" y: "+y+" distance: "+distance;
        }
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    public int shortestDistance(int[][] grid, int[] start, int[] target) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                return Integer.compare(p1.distance, p2.distance);
            }
        });

        pq.add(new Point(start[0], start[1], 0));
        HashSet<String> visited = new HashSet<>();
        while(!pq.isEmpty()) {
            int size = pq.size();
            //System.out.println(pq);
            for(int i = 0; i < size; i++) {
                Point e = pq.poll();
                String key = e.x+" "+e.y;
                if(e.x == target[0] && e.y == target[1]) return e.distance;

                //System.out.println(key);

                if(visited.contains(key)) continue;

                visited.add(key);
                for(int[] dir: dirs) {
                    int xNew = e.x;
                    int yNew = e.y;
                    int xPrev = xNew;
                    int yPrev = yNew;
                    int distance = e.distance;
                    while(xNew >= 0 && xNew < grid.length
                            && yNew >= 0 && yNew < grid[0].length && grid[xNew][yNew] != 1) {
                        //visited.add(xNew+" "+yNew);
                        xPrev = xNew;
                        yPrev = yNew;
                        xNew = xPrev + dir[0];
                        yNew = yPrev + dir[1];
                        distance++;
                    }
                    //System.out.println("x: "+e.x+" y: "+e.y+" in direction: "+dir[0]+", "+dir[1]+" becomes xNew: "+xPrev+" yNew: "+yPrev);
                    if(xPrev == e.x && yPrev == e.y || visited.contains(xPrev+" "+yPrev)) continue;
                    //visited.remove(xPrev+" "+yPrev);
                    pq.offer(new Point(xPrev, yPrev, distance - 1));
                }
            }
        }
        return -1;
    }
}
