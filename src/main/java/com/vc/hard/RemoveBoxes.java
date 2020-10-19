package com.vc.hard;

class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];

        for (int j = 0; j < n; j++) {
            for (int k = 0; k <= j; k++) {
                dp[j][j][k] = (k + 1) * (k + 1);
            }
        }

        for(int l = 1; l < n; l++) {
            for(int from = 0; from + l < n; from++) {
                int to = from + l;

                if(l == 1) dp[from][to][0] = 1;

                for(int same = 0; same <= from; same++) {
                    int res = (same + 1) * (same + 1) + dp[from + 1][to][0];
                    for(int middle = from + 1; middle <= to; middle++) {
                        if(boxes[middle] == boxes[from]) {
                            res = Math.max(res, dp[from + 1][middle - 1][0] + dp[middle][to][same + 1]);
                        }
                    }
                    dp[from][to][same] = res;
                }
            }
        }

        return (n == 0 ? 0 : dp[0][n - 1][0]);
    }
}