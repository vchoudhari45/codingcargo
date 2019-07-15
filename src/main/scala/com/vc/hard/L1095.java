package com.vc.hard;


// This is MountainArray's API interface.
// You should not implement it, or speculate about its implementation
interface MountainArray {
    public int get(int index);
    public int length();
}

class L0195 {
    public int findInMountainArray(int target, MountainArray arr) {
        int l = 0;
        int r = arr.length() - 1;
        int mid = 0;

        //Find Peak
        while(l <= r) {
            mid = l + (r - l) / 2;
            if(arr.get(mid) < arr.get(mid + 1)) {
                l = mid + 1;
            }
            else r = mid - 1;
        }

        int peak = l;


        //Find element in increasing Array using binary Search
        l = 0;
        r = peak;
        while(l <= r) {
            mid = l + (r - l) / 2;
            int element = arr.get(mid);
            if(element > target) {
                r = mid - 1;
            }
            else if(element < target) {
                l = mid + 1;
            }
            else return mid;
        }

        //Find element in decreasing Array using binary Search
        l = peak;
        r = arr.length() - 1;
        while(l <= r) {
            mid = l + (r - l) / 2;
            int element = arr.get(mid);
            if(element > target) {
                l = mid + 1;
            }
            else if(element < target) {
                r = mid - 1;
            }
            else return mid;
        }
        return -1;
    }
}