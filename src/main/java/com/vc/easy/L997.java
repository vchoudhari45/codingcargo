package com.vc.easy;

class L997 {
    public int findJudge(int N, int[][] trusts) {
        int[] countTrust = new int[N + 1];

        for(int[] trust: trusts) {
            int from = trust[0];
            int to = trust[1];

            countTrust[from]--;
            countTrust[to]++;
        }

        for(int i = 1; i <= N; i++) {
            if(countTrust[i] == N - 1) return i;
        }
        return -1;
    }
}
