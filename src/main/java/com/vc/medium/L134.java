package com.vc.medium;

class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int currentTank = 0;
        int index = 0;
        for(int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            currentTank += gas[i] - cost[i];
            if(currentTank < 0) {
                index = i + 1;
                currentTank = 0;
            }
        }
        return totalTank < 0 ? -1 : index;
    }
}
