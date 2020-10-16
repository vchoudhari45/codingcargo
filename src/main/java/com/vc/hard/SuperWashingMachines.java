package com.vc.hard;

class SuperWashingMachines {
    public int findMinMoves(int[] machines) {
        /**
             Case 1:
             Max Number of give outs will be your answer at every location
             1  0  5   avg = 2
             -1 -2  3   moves
             No matter what, we have to move all the 3 extra from last machine to left one by one and in this case give outs will be your answer.


             Case 2:
             But sometime there will be accumulated give outs which can trump the answer
             1  0  0  0  2  3  avg = 1
             0 -1 -1 -1  1  2  giveOut
             0  1  2  3  4  5  index
             In this case maxGiveOut = 2, but accumulated give outs(which is 3) will be our answer.

             Because index 4 and 5 will give out their load to index 3 to transfer to left, to make all the 0 on the left side to 1
             So Index 3 will have give out of 3 which is max moves
        */
        if(machines == null || machines.length == 0) return 0;

        int n = machines.length, sum = 0;
        for(int machine: machines) sum += machine;

        int avg = 0;
        if(sum % n == 0) avg = sum / n;
        else return -1;

        int moves = 0;
        int giveOuts = 0;
        int accumulatedGiveOuts = 0;
        for(int i = 0; i < machines.length; i++) {
            //See if giveOuts is our answer like in Case 1 described above
            giveOuts = machines[i] - avg;
            moves = Math.max(giveOuts, moves);

            //See if accumulatedGiveOuts is our answe like in Case 2 described above
            accumulatedGiveOuts += giveOuts;
            moves = Math.max(moves, Math.abs(accumulatedGiveOuts));
        }
        return moves;
    }
}