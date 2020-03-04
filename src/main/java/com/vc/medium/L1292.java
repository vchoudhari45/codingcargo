package com.vc.medium;

class L1292 {
    public int maxSideLength(int[][] arr, int threshold) {
        int n = arr.length;
        int m = arr[0].length;

        /**

                0 1 2 3 4 5 6
             0 [1 1 3 2 4 3 2]
             1 [1 1 3 2 4 3 2]
             2 [1 1 3 2 4 3 2]

                0 1 2  3  4  5  6  7
             0 [0 0 0  0  0  0  0  0]
             1 [0 1 2  5  7 11 14 16]
             2 [0 2 4 10 14 22 28 32]
             3 [0 1 4 13 19 31 40 46]

             side = Math.min(3, 7)  = 3

             R1 = 0
             C1 = 0

             R2 = 3
             C2 = 3

             prefix[R2][C2] - prefix[R1][C2] - prefix[R2][C1] + prefix[R1][C1]
         */

        int[][] prefix = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] + arr[i - 1][j - 1] - prefix[i - 1][j - 1];
            }
        }

        for(int side = Math.min(n, m); side > 0; side--) {
            for(int i = 0; i + side <= n; i++) {
                for(int j = 0; j + side <= m; j++) {
                    int R1 = i;
                    int C1 = j;

                    int R2 = i + side;
                    int C2 = j + side;

                    int sum = prefix[R2][C2] - prefix[R1][C2] - prefix[R2][C1] + prefix[R1][C1];

                    if(sum <= threshold) return side;
                }
            }
        }
        return 0;
    }
}