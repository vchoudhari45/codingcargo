package com.vc.hard;

class L546 {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int dp[][][] = new int[n][n][n];
        return solve(0, n - 1, 0, boxes, dp);
    }

    public int solve(int left, int right, int same, int[]boxes, int[][][] dp) {
        if(left > right) return 0;
        if(dp[left][right][same] > 0) return dp[left][right][same];

        while(left + 1 <= right && boxes[left + 1] == boxes[left]) {
            same++;
            left++;
        }

        dp[left][right][same] = (same + 1) * (same + 1) + solve(left + 1, right, 0, boxes, dp);

        for(int k = left + 1; k <= right; k++) {
            if(boxes[k] == boxes[left]) {
                dp[left][right][same] = Math.max(
                        dp[left][right][same],
                        solve(left + 1, k - 1, 0, boxes, dp) + solve(k, right, same + 1, boxes, dp)
                );
            }
        }
        return dp[left][right][same];
    }
}