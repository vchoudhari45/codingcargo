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

    public void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<>();
        helper(robot, 0, 0, 0, visited);
    }

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private void helper(Robot robot, int x, int y, int direction, HashSet<String> visited) {
        String key = x + " "+ y;
        if(visited.contains(key)) return;

        visited.add(key);
        robot.clean();

        for(int i = 0; i < dirs.length; i++) {
            if(robot.move()) {
                int xNew = x + dirs[direction][0];
                int yNew = y + dirs[direction][1];

                helper(robot, xNew, yNew, direction, visited);

                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            direction = (direction + 1) % 4;
        }
    }
}
