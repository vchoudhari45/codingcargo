package com.vc.medium;

import java.util.*;

class L881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;

        int res = 0;
        while(left <= right) {
            if(people[left] + people[right] <= limit) left++;
            right--;
            res++;
        }
        return res;
    }
}