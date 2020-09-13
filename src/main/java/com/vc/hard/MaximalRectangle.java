package com.vc.hard;

import java.util.*;

class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] row = new int[n];
        int maxLength = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') row[j] += 1;
                else row[j] = 0;
            }
            maxLength = Math.max(maxLength, maxRectangle(row));
        }
        return maxLength;
    }

    private int maxRectangle(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLength = 0;
        for(int i = 0; i < heights.length; i++) {
            while(st.peek() != -1 && heights[st.peek()] > heights[i]) {
                maxLength = Math.max(maxLength, heights[st.pop()] * (i - st.peek() - 1));
            }
            st.push(i);
        }
        while(st.peek() != -1) {
            maxLength = Math.max(maxLength, heights[st.pop()] * (heights.length - st.peek() - 1));
        }
        return maxLength;
    }
}