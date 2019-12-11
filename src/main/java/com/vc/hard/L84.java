package com.vc.hard;

import java.util.*;

class L84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int current = 0;
        int n = heights.length;
        int maxArea = Integer.MIN_VALUE;
        while(current < n) {
            System.out.println("current: "+current+" height: "+heights[current]);
            if(st.isEmpty() || heights[st.peek()] <= heights[current]) {
                st.push(current);
            }
            else {
                while(!st.isEmpty() && heights[st.peek()] > heights[current]) {
                    int height = heights[st.pop()];
                    int prevIndex = !st.isEmpty() ? st.peek() : -1;
                    System.out.println("stack: "+st+" height: "+height+" prevIndex: "+prevIndex);
                    int area = height * current - prevIndex - 1;
                    maxArea = Math.max(maxArea, area);
                }
            }
            current++;
        }
        while(!st.isEmpty()) {
            int height = heights[st.pop()];
            int prevIndex = !st.isEmpty() ? st.peek() : -1;
            System.out.println("stack: "+st+" height: "+height+" prevIndex: "+prevIndex);
            int area = height * current - prevIndex - 1;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
