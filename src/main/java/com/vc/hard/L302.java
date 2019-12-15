package com.vc.hard;

class L302 {
    int dirs[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int top = 0, bottom = 0, left = 0, right = 0;

    public int minArea(char[][] image, int x, int y) {
        top = image.length;
        bottom = 0;
        left = image[0].length;
        right = 0;
        solve(image, x, y);
        return (bottom - top + 1) * (right - left + 1);
    }

    private void assign(int x, int y) {
        top = Math.min(top, x);
        bottom = Math.max(bottom, x);
        left = Math.min(left, y);
        right = Math.max(right, y);
    }

    private void solve(char[][] image, int x, int y) {
        if(image[x][y] == '1') {
            image[x][y] = 0;
            assign(x, y);
            for(int[] dir: dirs) {
                int xNew = dir[0] + x;
                int yNew = dir[1] + y;
                if(xNew >= 0 && xNew < image.length
                        && yNew >= 0 && yNew < image[0].length) {
                    solve(image, xNew, yNew);
                }
            }
        }
    }
}
