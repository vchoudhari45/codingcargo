package com.vc.medium;

class L1329 {

    private int[][] mat;
    private int n = 0, m = 0;

    public int[][] diagonalSort(int[][] mat) {
        this.mat = mat;

        int n = mat.length;
        if(n == 0) return mat;

        int m = mat[0].length;
        if(m == 0) return mat;

        this.n = n;
        this.m = m;

        //0th Row
        for(int col = 0; col < m; col++) {
            sort(0, col);
        }

        //0th Col
        for(int row = 1; row < n; row++) {
            sort(row, 0);
        }
        return mat;
    }

    private void sort(int rDiagonal, int cDiagonal) {
        int rTo = rDiagonal + 1, cTo = cDiagonal + 1;
        while(rTo < n && cTo < m) {
            int r = rDiagonal, c = cDiagonal;
            while(r < rTo && c < cTo) {
                if(mat[r][c] > mat[rTo][cTo]) swap(r, c, rTo, cTo);
                r++;
                c++;
            }
            rTo++;
            cTo++;
        }
    }

    private void swap(int fromR, int fromC, int toR, int toC) {
        int temp = mat[fromR][fromC];
        mat[fromR][fromC] = mat[toR][toC];
        mat[toR][toC] = temp;
    }
}
