package com.vc.medium;

import java.util.*;

class L1222 {

    private int[][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1},{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        HashSet<String> points = new HashSet<>();
        for(int[] queen: queens) {
            String str = queen[0]+" "+queen[1];
            points.add(str);
        }

        int kx = king[0], ky = king[1];
        List<List<Integer>> res = new ArrayList<>();
        for(int[] dir: dirs) {
            int qxNew = kx + dir[0], qyNew = ky + dir[1];
            while(qxNew >= 0 && qxNew < 8 && qyNew >= 0 && qyNew < 8) {
                String key = qxNew +" "+ qyNew;
                if(points.contains(key)) {
                    res.add(Arrays.asList(qxNew, qyNew));
                    break;
                }
                qxNew += dir[0];
                qyNew += dir[1];
            }
        }
        return res;
    }
}
