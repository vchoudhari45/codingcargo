package com.vc.medium;

class L562 {
    static class Directions {
        int h, v, d, a;

        Directions(int h, int v, int d, int a) {
            this.h = h;
            this.v = v;
            this.d = d;
            this.a = a;
        }

        @Override
        public String toString() {
            return "("+h+", "+v+", "+d+", "+a+") ";
        }
    }

    public int longestLine(int[][] A) {
        if(A == null || A.length == 0) return 0;

        /**
             [
                 [0,1,0,1,1],
                 [1,1,0,0,1],
                 [0,0,0,1,0],
                 [1,0,1,1,1],
                 [1,0,0,0,1]
             ]
         */
        int n = A.length, m = A[0].length, max = 0;
        Directions[][] dp = new Directions[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                dp[i][j] = new Directions(0, 0, 0, 0);
            }
        }

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j++) {
                if(A[i][j] == 0) continue;

                if(i == 0 && j == 0) {
                    dp[i][j].h = 1;
                    dp[i][j].v = 1;
                    dp[i][j].d = 1;
                    dp[i][j].a = 1;
                }
                else if(i == 0) {
                    dp[i][j].h = 1;
                    dp[i][j].v = dp[i][j - 1].v + 1;
                    dp[i][j].d = 1;
                    dp[i][j].a = 1;
                }
                else if(j == 0) {
                    dp[i][j].h = dp[i - 1][j].h + 1;
                    dp[i][j].v = 1;
                    dp[i][j].d = 1;
                    dp[i][j].a = j + 1 < m ? (dp[i - 1][j + 1].a + 1) : 1;
                }
                else {
                    dp[i][j].h = dp[i - 1][j].h + 1;
                    dp[i][j].v = dp[i][j - 1].v + 1;
                    dp[i][j].d = dp[i - 1][j - 1].d + 1;
                    dp[i][j].a = j + 1 < m ? (dp[i - 1][j + 1].a + 1) : 1;
                }

                int h = dp[i][j].h;
                int v = dp[i][j].v;
                int d = dp[i][j].d;
                int a = dp[i][j].a;
                //System.out.println(dp[i][j]+" "+A[i][j]+" i: "+i+" j:"+j);
                max = Math.max(max, Math.max(a, Math.max(d, Math.max(h, v))));
            }
        }
        return max;
    }
}