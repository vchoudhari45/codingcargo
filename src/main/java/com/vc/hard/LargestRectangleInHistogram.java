package com.vc.hard;

import java.util.Stack;

class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxHeight = 0;
        for(int i = 0; i < heights.length; i++) {
            while(st.peek() != -1 && heights[st.peek()] > heights[i]) {
                maxHeight = Math.max(maxHeight, heights[st.pop()] * (i - st.peek() - 1));
            }
            st.push(i);
        }
        while(st.peek() != -1) {
            maxHeight = Math.max(maxHeight, heights[st.pop()] * (heights.length - st.peek() - 1));
        }
        return maxHeight;
    }
}
