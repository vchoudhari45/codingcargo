package com.vc.hard;

class L517 {
    public int findMinMoves(int[] machines) {
        //https://leetcode.com/problems/super-washing-machines/discuss/99185/Super-Short-and-Easy-Java-O(n)-Solution
        int sum = sum(machines);
        int currentDiff = 0;
        int runningDiff = 0;
        int max = 0;
        int need = sum / machines.length;
        if(sum % machines.length != 0) return -1;

        for(int i = 0; i < machines.length; i++) {
            currentDiff = machines[i] - need;
            runningDiff += currentDiff;
            max = Math.max(max, Math.abs(runningDiff));
            max = Math.max(max, currentDiff);
        }
        return max;
    }

    private int sum(int[] machines) {
        int sum = 0;
        for(int i = 0; i < machines.length; i++) sum += machines[i];
        return sum;
    }
}