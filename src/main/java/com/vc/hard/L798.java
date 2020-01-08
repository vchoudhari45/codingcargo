package com.vc.hard;

class L798 {
    public int bestRotation(int[] arr) {
        int n = arr.length;
        int[] points = new int[n];

        //https://leetcode.com/problems/smallest-rotation-with-highest-score/discuss/130531/A-(hopefully)-understandable-explanation-O(n)
        for(int i = 0; i < n; i++) {
            //current element and current index
            int num = arr[i];
            int index = i;

            //Below Index range will give us a point
            int startIndex = num;

            //Left Rotations to reach startIndex & endIndex from index
            int startIndexRotation = (index + n - startIndex + 1) % n;
            int endIndexRotation = (index + 1) % n;

            points[startIndexRotation]--;
            points[endIndexRotation]++;

            // System.out.println("\nFor "+num+
            //                    " startIndex "+startIndex+
            //                    " endIndex "+endIndex+
            //                    " startIndexRotation "+startIndexRotation+
            //                    " endIndexRotation "+endIndexRotation+")");
        }

        int max = -1;
        int count = 0;
        int rotation = 0;
        for(int i = 0; i < n; i++) {
            count += points[i];
            if(max < count) {
                max = count;
                rotation = i;
            }
        }
        return rotation;
    }
}