package com.vc.hard;

class NumMatrix {
    //https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms
    int m;
    int n;
    int[][] tree;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.m = matrix.length;
        if(m == 0) return;
        this.n = matrix[0].length;
        this.matrix = matrix;
        tree = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                set(i, j, matrix[i][j]);
            }
        }
    }

    private void set(int row, int col, int val) {
        if(m == 0 || n == 0) return;
        for(int i = row + 1; i <= m; i = getNext(i)) {
            for(int j = col + 1; j <= n; j = getNext(j)) {
                tree[i][j] += val;
            }
        }
    }

    public void update(int row, int col, int val) {
        if(m == 0 || n == 0) return;
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        set(row, col, delta);
    }

    private int sum(int row, int col) {
        int sum = 0;
        if(m == 0 || n == 0) return sum;
        for(int i = row; i > 0; i = getParent(i)) {
            for(int j = col; j > 0; j = getParent(j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    private int getParent(int x) {
        return x - (x & -x);
    }

    private int getNext(int x) {
        return x + (x & -x);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2 + 1, col2 + 1) + sum(row1, col1) - sum(row1, col2 + 1) - sum(row2 + 1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
