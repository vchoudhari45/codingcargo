package com.vc.hard;

class SmallestRectangleEnclosingBlackPixels {

    private int top, bottom, left, right = 0;
    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0) return 0;

        top = image.length - 1;
        bottom = 0;
        left = image[0].length - 1;
        right = 0;

        helper(image, x, y);

        return (right - left + 1) * (bottom - top + 1);
    }

    private int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void helper(char[][] image, int x, int y) {
        if(image[x][y] == 0) return;

        image[x][y] = 0;
        top = Math.min(x, top);
        bottom = Math.max(bottom, x);
        left = Math.min(left, y);
        right = Math.max(right, y);
        for(int[] dir: dirs) {
            int xNew = x + dir[0];
            int yNew = y + dir[1];
            if(xNew >= 0 && xNew < image.length && yNew >= 0 && yNew < image[0].length
                    && image[xNew][yNew] == '1') {
                helper(image, xNew, yNew);
            }
        }
    }
}