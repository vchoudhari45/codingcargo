package com.vc.hard;

class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        /**
             If we have 1 attempt we have Two states
             -Pig is Alive
             -Pig is Dead

             If we have 2 attempts we have Three states
             -Pig is Alive
             -Pig is Dead After 1st attempt
             -Pig is Dead After 2nd attempt

             And so on...

             Now think of states as Base and Bucket as Number to represent, how many digits are needed
        */
        int attempts = minutesToTest / minutesToDie;
        int states = attempts + 1;
        return (int)Math.ceil(Math.log(buckets) / Math.log(states));
    }
}