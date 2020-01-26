package com.vc.medium;

import java.util.*;

class L955 {
    public int minDeletionSize(String[] A) {
        HashSet<Integer> toBeDeleted = new HashSet<>();
        for(int row = 1; row < A.length; row++) {
            //Match current & prev row for all the columns
            for(int col = 0; col < A[row].length(); col++) {
                if(toBeDeleted.contains(col) || A[row - 1].charAt(col) == A[row].charAt(col)) continue;
                if(A[row - 1].charAt(col) > A[row].charAt(col)) {
                    /**
                     If current row character is less than prev row character for a column,
                     add that column to the Hashset
                     */
                    toBeDeleted.add(col);

                    /**
                     Restart row, cause deleting column might change ordering of previously ordered rows
                     */
                    row = 0;
                }
                break;
            }
        }
        return toBeDeleted.size();
    }
}
