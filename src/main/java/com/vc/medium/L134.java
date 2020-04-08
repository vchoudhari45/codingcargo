package com.vc.medium;

class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currentTank = 0, totalTank = 0, index = 0;
        for(int i = 0; i < gas.length; i++) {
            currentTank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];
            if(currentTank < 0) {
                index = i + 1;
                currentTank = 0;
            }
        }
        return totalTank >= 0 ? index : -1;
    }
}