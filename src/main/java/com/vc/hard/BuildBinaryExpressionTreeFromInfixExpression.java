package com.vc.hard;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
class BuildBinaryExpressionTreeFromInfixExpression {
    public TreeNode expTree(String s) {
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }
        return helper(q);
    }

    private TreeNode helper(Queue<Character> q) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();

        char prevSign = ' ';
        while(!q.isEmpty()) {
            char ch = q.poll();

            if(Character.isDigit(ch) || ch == '(') {
                TreeNode currentOperand = ch == '(' ? helper(q) : new TreeNode(ch);

                if(prevSign == '-' || prevSign == '+') {
                    deque.addLast(new TreeNode(prevSign));
                    deque.addLast(currentOperand);
                }
                else if(prevSign == '*' || prevSign == '/') {
                    TreeNode prevOperand = deque.pollLast();
                    TreeNode signNode = new TreeNode(prevSign);
                    signNode.left = prevOperand;
                    signNode.right = currentOperand;
                    deque.addLast(signNode);
                }
                else {
                    deque.addLast(currentOperand);
                }
            }
            else if(ch == ')') break;
            else prevSign = ch;
        }

        while(deque.size() > 1) {
            TreeNode first = deque.pollFirst();
            TreeNode operator = deque.pollFirst();
            TreeNode second = deque.pollFirst();

            operator.left = first;
            operator.right = second;
            deque.addFirst(operator);
        }
        return deque.pollLast();
    }
}
