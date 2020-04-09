package com.vc.easy;

class L88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first = m - 1;
        int second = n - 1;
        int index = m + n - 1;
        while(first >= 0 && second >= 0) {
            if(nums1[first] > nums2[second]) {
                nums1[index] = nums1[first--];
            }
            else {
                nums1[index] = nums2[second--];
            }
            index--;
        }

        while(first >= 0) {
            nums1[index--] = nums1[first--];
        }

        while(second >= 0) {
            nums1[index--] = nums2[second--];
        }
    }
}
