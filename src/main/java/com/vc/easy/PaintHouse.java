package com.vc.easy;


/*****
 *  Problem No: 256
 *  Category: Data Structures And Algorithms
 *  Tags: Dynamic Programming, Leetcode, Easy
 *  Title: Paint House
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. It is an easy problem that uses Dynamic Programming to solve the problem.
 *  Description: There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color. The cost of painting each house with a certain color is represented by a n x 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 *  Input: [[17,2,17],[16,16,5],[14,3,19]]
 *  Output: 10
 *  Similar Question: House Robber, House Robber II, Paint House II, Paint Fence
 *****/

class PaintHouse {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;

        int n = costs.length;
        for(int currentRow = n - 2; currentRow >= 0; currentRow--) {
            int nextRow = currentRow + 1;
            costs[currentRow][0] += Math.min(costs[nextRow][1], costs[nextRow][2]);
            costs[currentRow][1] += Math.min(costs[nextRow][0], costs[nextRow][2]);
            costs[currentRow][2] += Math.min(costs[nextRow][0], costs[nextRow][1]);
        }
        return Math.min(Math.min(costs[0][0], costs[0][1]), costs[0][2]);
    }
}