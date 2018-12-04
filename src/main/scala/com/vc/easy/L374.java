package com.vc.easy;

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class L374 {
    public int guessNumber(int n) {
        int lo = 0;
        int hi = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int guess = guess(mid);
            if(guess > 0) {
                lo = mid + 1;
            }
            else if(guess < 0) {
                hi = mid - 1;
            }
            else return mid;
        }
        return lo;
    }

    //dummy function as placeholder it is implemented in leetcode
    //so remove below function when you will try this solution on leetcode
    public int guess(int n) {
        return 0;
    }
}
