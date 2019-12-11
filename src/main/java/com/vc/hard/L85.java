package com.vc.hard;

import java.util.*;

class L85 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;

        int[] arr = new int[n];
        int maxArea = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == '1') arr[j] += 1;
                else arr[j] = 0;
            }
            int area = maxRectangle(arr, n);
            maxArea = Math.max(area, maxArea);
            // System.out.println("Area: "+area);
            // for(int j = 0; j < n; j++) {
            //     System.out.print(arr[j]+" ");
            // }
            // System.out.println(" ");
        }
        return maxArea;
    }

    private int maxRectangle(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int current = 0;
        int maxArea = 0;
        while(current < n) {
            if(st.isEmpty() || arr[st.peek()] <= arr[current]) {
                st.push(current);
            }
            else {
                while(!st.isEmpty() && arr[st.peek()] > arr[current]) {
                    int height = arr[st.pop()];
                    int width = current - (!st.isEmpty() ? st.peek() : -1) - 1;
                    int area = height * width;
                    maxArea = Math.max(maxArea, area);
                }
                st.push(current);
            }
            current++;
        }
        while(!st.isEmpty()) {
            int height = arr[st.pop()];
            int width = current - (!st.isEmpty() ? st.peek() : - 1) - 1;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
