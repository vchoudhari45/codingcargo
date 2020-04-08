package com.vc.hard;

class L517 {
    public int findMinMoves(int[] machines) {
        /**
             Max Number of give outs will be your answer at every location

             1  0  5   avg = 2
             -1 -2  3   giveOut

             No matter what we have to move all the 3 extra from last machine to left one by one that will be your answer

             But sometime there will be accumulated give outs which can trump the answer

             1  0  0  0  2  3  avg = 1
             0 -1 -1 -1  1  2  giveOut
             0  1  2  3  4  5  index

             maxGiveOut = 2
             But accumulated give outs in this case will be more 3, why?
             Because index 4 and 5 will give out their load to index 3 to transfer to left
             To make all the 0 on the left side to 1
             so Index 3 will have Give out of 3 which is max moves
         */

        if(machines == null || machines.length == 0) return 0;

        int n = machines.length;
        int sum = 0;
        for(int i = 0; i < n; i++) sum += machines[i];

        int avg = 0;
        if(sum % n == 0) avg = sum / n;
        else return -1;

        int moves = 0, accumulatedGiveOuts = 0;
        for(int i = 0; i < n; i++) {
            int giveOut = machines[i] - avg;
            moves = Math.max(moves, giveOut);   //GiveOuts will always be positive
            accumulatedGiveOuts += giveOut;
            moves = Math.max(moves, Math.abs(accumulatedGiveOuts)); // accumulatedGiveOuts
        }
        return moves;
    }
}