package com.vc.medium;

class L498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int n = matrix.length;
        if(n == 0) return new int[0];
        int m = matrix[0].length;
        int[] res = new int[n * m];

        int r = 0;
        int c = 0;
        for(int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            //System.out.println(res[i]);
            if((r + c) % 2 == 0) { // Moving up
                if(c == m - 1) r++;
                else if(r == 0) c++;
                else {
                    r--;
                    c++;
                }
            }
            else { // Moving down
                if(r == n - 1) c++;
                else if(c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return res;
    }
}
