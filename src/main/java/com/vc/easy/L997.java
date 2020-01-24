package com.vc.easy;

class L997 {
    public int findJudge(int N, int[][] trust) {
        int[] countTrust = new int[N + 1];
        int[] countTrustOutside = new int[N + 1];

        for(int[] t: trust) {
            countTrustOutside[t[0]]++;
            countTrust[t[1]]++;
        }

        for(int i = 1; i <= N; i++) {
            //System.out.println(i+"->"+countTrust[i]+"->"+countTrustOutside[i]);
            if(countTrust[i] == N - 1 && countTrustOutside[i] == 0) return i;
        }
        return -1;
    }
}
