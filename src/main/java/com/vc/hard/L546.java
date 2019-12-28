package com.vc.hard;

class L546 {
    int[][][] m;
    public int removeBoxes(int[] boxes) {
        if(boxes == null || boxes.length == 0) return 0;
        int n = boxes.length;
        m = new int[n][n][n];
        return dfs(boxes, 0, n - 1, 0);
    }

    private int dfs(int[] boxes, int l, int r, int k) {
        if(l > r) return 0;
        while(r > 0 && boxes[r] == boxes[r - 1]) {
            r--;
            k++;
        }
        if(m[l][r][k] > 0) return m[l][r][k];
        m[l][r][k] = dfs(boxes, l, r - 1, 0) + (k + 1) * (k + 1);
        for(int i = l; i < r; i++) {
            if(boxes[i] == boxes[r]) {
                m[l][r][k] = Math.max(m[l][r][k], dfs(boxes, l, i, k + 1) + dfs(boxes, i + 1, r - 1, 0));
            }
        }
        return m[l][r][k];
    }
}