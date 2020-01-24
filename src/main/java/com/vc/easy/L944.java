package com.vc.easy;

import java.util.*;

class L944 {
    public int minDeletionSize(String[] arr) {
        HashSet<Integer> invalid = new HashSet<>();
        for(int row = 1; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length(); col++) {
                if(arr[row].charAt(col) < arr[row - 1].charAt(col)) invalid.add(col);
            }
        }
        return invalid.size();
    }
}
