package com.vc.medium;

import java.util.*;

class L519 {

    Map<Integer, Integer> map;
    int total, row, col;
    Random r;
    public L519(int n_rows, int n_cols) {
        this.total = n_rows * n_cols;
        this.row = n_rows;
        this.col = n_cols;
        map = new HashMap<Integer, Integer>();
        r = new Random();
    }

    public int[] flip() {
        int randomTotal = r.nextInt(total--);
        int useTotal = map.getOrDefault(randomTotal, randomTotal);
        map.put(randomTotal, map.getOrDefault(total, total));
        return new int[]{useTotal / col, useTotal % col};
    }

    public void reset() {
        map.clear();
        total = row * col;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
