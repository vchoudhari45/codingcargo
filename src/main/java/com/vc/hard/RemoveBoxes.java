package com.vc.hard;

class RemoveBoxes {
    public int removeBoxes(int[] boxes) {
        if(boxes == null || boxes.length == 0) return 0;
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(boxes, 0, n - 1, 0, dp);
    }

    private int helper(int[] boxes, int left, int right, int same, int[][][] dp) {
        if(left > right) return 0;

        if(dp[left][right][same] != 0) return dp[left][right][same];

        int res = (same + 1) * (same + 1) + helper(boxes, left + 1, right, 0, dp);

        for(int middle = left + 1; middle <= right; middle++) {
            if(boxes[left] == boxes[middle]) {
                res = Math.max(res, helper(boxes, left + 1, middle - 1, 0, dp) + helper(boxes, middle, right, same + 1, dp));
            }
        }

        dp[left][right][same] = res;
        return res;
    }
}