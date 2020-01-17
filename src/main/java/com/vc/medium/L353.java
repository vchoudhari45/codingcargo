package com.vc.medium;

import java.util.*;

class SnakeGame {

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "("+x+", "+y+")";
        }
    }

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    private int width, height, score, foodIndex;
    private Deque<Position> body;
    private HashSet<String> bodyLookup;
    private int[][] food;
    public SnakeGame(int width, int height, int[][] food) {
        body = new LinkedList<>();
        this.food = food;
        bodyLookup = new HashSet<>();
        body.add(new Position(0, 0));
        bodyLookup.add("0->0");
        this.width = width;
        this.height = height;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        //System.out.println("========================================================");
        Position head = body.peekFirst();
        Position tail = null;

        int xNew = head.x;
        int yNew = head.y;
        if(direction.equals("U")) {
            xNew -= 1;
        }
        else if(direction.equals("D")) {
            xNew += 1;
        }
        else if(direction.equals("L")) {
            yNew -= 1;
        }
        else if(direction.equals("R")) {
            yNew += 1;
        }

        if(xNew >= 0 && xNew < height && yNew >= 0 && yNew < width) {
            if(foodIndex < food.length && food[foodIndex][0] == xNew && food[foodIndex][1] == yNew) {
                food[foodIndex][0] = -1;
                food[foodIndex++][1] = -1;
                score++;
            }
            else if(body.size() > 0) {
                tail = body.pollLast();
                bodyLookup.remove(tail.x+"->"+tail.y);
            }
            body.offerFirst(new Position(xNew, yNew));
            if(!bodyLookup.add(xNew+"->"+yNew)) {
                score = -1;
            }
        }
        else score = -1;

        // if(tail != null)
        //     System.out.println(" After Adding: "+xNew+", "+yNew+" For direction: "+direction+" and Removing "+tail.x+", "+tail.y+" Snake becomes: "+body+" body "+bodyLookup);
        // else
        //     System.out.println(" After Adding: "+xNew+", "+yNew+" For direction: "+direction+" Snake becomes: "+body+" body "+bodyLookup);

        return score;
    }
}

/**
 ["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move"]
 [[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
 */

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
