package com.vc.medium;

class L1292 {
    public int maxSideLength(int[][] arr, int threshold) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] prefix = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] + arr[i - 1][j - 1] - prefix[i - 1][j - 1];
            }
        }

        // for(int i = 0; i <= n; i++) {
        //     for(int j = 0; j <= m; j++) {
        //         System.out.format("%4d", prefix[i][j]);
        //     }
        //     System.out.println();
        // }

        for(int side = Math.min(n, m) - 1; side > 0; side--) {
            for(int i = 1; i + side <= n; i++) {
                for(int j = 1; j + side <= m; j++) {
                    // System.out.println("prefix[i + side][j + side]: " +prefix[i + side][j + side]
                    //                   +" prefix[i - 1][j + side]: "+prefix[i - 1][j + side]
                    //                   +" prefix[i + side][j - 1]: "+prefix[i + side][j - 1]
                    //                   +" prefix[i - 1][j - 1]: "+prefix[i - 1][j - 1]);
                    int sum = prefix[i + side][j + side]
                            - prefix[i - 1][j + side] - prefix[i + side][j - 1]
                            + prefix[i - 1][j - 1];
                    if(sum <= threshold) return side + 1;
                }
            }
        }
        return 0;
    }
}
