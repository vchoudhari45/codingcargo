package com.vc.hard;

import java.util.*;

class RobotRoomCleaner {
    /**
     * This is the robot's control interface.
     * You should not implement it, or speculate about its implementation
     **/
    interface Robot {
        /**
         * Returns true if the cell in front is open and robot moves into the cell.
         * Returns false if the cell in front is blocked and robot stays in the current cell.
         **/
        boolean move();

        /**
         * Robot will stay in the same cell after calling turnLeft/turnRight.
         * Each turn will be 90 degrees.
         **/
        void turnLeft();
        void turnRight();

        /**
         * Clean the current cell.
         **/
        void clean();
    }

    int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<String>();
        backtracking(robot, visited, 0, 0, 0);
    }

    public void backtracking(Robot robot, Set<String> visited, int x, int y, int dir) {
        String p = x +"->"+ y;
        if(visited.contains(p)) return;
        visited.add(p);
        robot.clean();

        for(int i = 0; i < 4; i++) {
            if(robot.move()) {
                int nx = x + dirs[dir][0];
                int ny = y + dirs[dir][1];

                backtracking(robot, visited, nx, ny, dir);

                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            dir = (dir + 1) % 4;
        }
    }
}
