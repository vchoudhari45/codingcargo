package com.vc.hard;

import java.util.*;

class L749 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+" "+y+")";
        }
    }

    public int containVirus(int[][] grid) {
        int res = 0;

        int n = grid.length;
        if(n == 0) return res;
        int m = grid[0].length;

        while(true) {
            //printArr(grid);
            List<HashSet<Point>> walls = new ArrayList<>();
            List<Integer> area = new ArrayList<>();
            List<HashSet<Point>> regions = new ArrayList<>();

            HashSet<String> visited = new HashSet<>();
            for(int i = 0; i < grid.length; i++) {
                for(int j = 0; j < grid[0].length; j++) {
                    if(grid[i][j] == 1 && !visited.contains(i+" "+j)) {
                        //System.out.println("Starting new region: ");
                        regions.add(new HashSet<Point>());
                        walls.add(new HashSet<Point>());
                        area.add(0);
                        dfs(grid, i, j, walls, area, regions, visited, new HashSet<String>());
                    }
                }
            }

            if(regions.size() == 0) return res;

            int maxIndex = 0;
            for(int i = 0; i < area.size(); i++) {
                if(area.get(i) > area.get(maxIndex)) {
                    maxIndex = i;
                }
            }

            // for(int i = 0; i < regions.size(); i++) {
            //     System.out.println(regions.get(i)+" "+walls.get(i).size());
            // }

            res += walls.get(maxIndex).size();

            block(grid, maxIndex, regions);
            infect(grid, maxIndex, regions);
        }
    }

    private void printArr(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                System.out.format("%4d", grid[i][j]);
            }
            System.out.println();
        }
    }

    private int[][] dirs = {{1, 0},{0, 1},{-1, 0},{0, -1}};
    private void block(int[][] grid, int index, List<HashSet<Point>>regions) {
        for(Point p: regions.get(index)) {
            grid[p.x][p.y] = -1;
        }
    }

    private void infect(int[][] grid, int blockedIndex, List<HashSet<Point>>regions) {
        for(int i = 0; i < regions.size(); i++) {
            if(i != blockedIndex) {
                HashSet<Point> region = regions.get(i);
                for(Point p: region) {
                    for(int[] dir: dirs) {
                        int xNew = p.x + dir[0];
                        int yNew = p.y + dir[1];

                        if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length
                                && grid[xNew][yNew] == 0) {
                            grid[xNew][yNew] = 1;
                        }
                    }
                }
            }
        }
    }

    private void dfs(int[][] grid, int x, int y, List<HashSet<Point>> walls, List<Integer> area,
                     List<HashSet<Point>> regions, HashSet<String> visited, HashSet<String> areaVisited) {
        if(!visited.contains(x+" "+y)) {
            visited.add(x+" "+y);

            //System.out.println("---> Adding point: "+x+" "+y);

            //Add point to region
            int index = regions.size() - 1;
            regions.get(index).add(new Point(x, y));

            for(int[] dir: dirs) {
                int xNew = x + dir[0];
                int yNew = y + dir[1];

                if(xNew >= 0 && xNew < grid.length && yNew >= 0 && yNew < grid[0].length) {
                    if(grid[xNew][yNew] == 1) {
                        dfs(grid, xNew, yNew, walls, area, regions, visited, areaVisited);
                    }
                    else if(grid[xNew][yNew] == 0) {
                        //Add point to walls
                        walls.get(index).add(new Point(xNew, yNew));

                        if(!areaVisited.contains(xNew+" "+yNew)) {
                            areaVisited.add(xNew+" "+yNew);
                            //Add to area
                            area.set(index, area.get(index) + 1);
                        }
                    }
                }
            }
        }
    }
}