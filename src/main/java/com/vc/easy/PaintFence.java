package com.vc.easy;


/*****
 *  Problem No: 276
 *  Category: Data Structures And Algorithms
 *  Tags: Dynamic Programming, Google, Leetcode, Easy
 *  Title: Paint Fence
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, There is a fence with n posts, each post can be painted with one of the k colors. You have to paint all the posts such that no more than two adjacent fence posts have the same color. Return the total number of ways you can paint the fence. It is an easy problem that uses Dynamic Programming to solve the problem.
 *  Description: There is a fence with n posts, each post can be painted with one of the k colors. You have to paint all the posts such that no more than two adjacent fence posts have the same color. Return the total number of ways you can paint the fence.
 *  Input: n = 3, k = 2
 *  Output: 6
 *  Similar Question: House Robber, House Robber II, Paint House, Paint House II
 *****/

class PaintFence {
    public int numWays(int posts, int colors) {
        if(posts == 0) return 0;
        if(posts == 1) return colors;
        if(posts == 2) return colors * colors;

        int total_post_minus_2 = colors;            //Base Condition
        int total_post_minus_1 = colors * colors;  //Base Condition

        int total_post_current = 0;
        for(int post = 3; post <= posts; post++) {
            /**
                 Formula Explanation:
                 Total ith location = Paint Different than (i - 1) + Paint Same As (i - 1)

                 Paint Different than (i - 1) = Total(i - 1)th location * (k - 1)
                 Paint Same As (i - 1) = Painted Different(i - 1)th location * k
                                       = Painted Different(i - 1) location = Total (i - 2)th location * (k - 1)

                 So
                 Total ith location = Total(i - 1)th location * (k - 1) + Total (i - 2)th location * (k - 1)
                                    = (Total(i - 1)th location + Total(i - 2)th location) * (k - 1)
            */
            total_post_current = (total_post_minus_2 + total_post_minus_1) * (colors - 1);
            total_post_minus_2 = total_post_minus_1;
            total_post_minus_1 = total_post_current;
        }
        return total_post_current;
    }
}
