package com.vc.medium;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */


//Dummy Implementation
class Relation {
    boolean knows(int a, int b) {
        return false;
    }
}

class L277 extends Relation {
    public int findCelebrity(int n) {
        int celeb = 0;
        for(int i = 1; i < n; i++){
            /**
             Start by celeb = 0
             if celeb know i then i is not celeb
             */
            if(knows(celeb, i)){
                celeb = i;
            }
        }
        for(int i = 0; i < n; i++){
            //Other than celeb should know 2 here because every body else know the celeb
            //0 & 1 are not celeb because they know 2 and 3 & 4 are not celeb because 2 doesn't know them
            //we are left with only 2 now if everybody know 2 then we are good
            if(i != celeb && (knows(celeb, i) || !knows(i, celeb))) return -1;
        }
        return celeb;
    }
}
