package com.vc.hard;

import java.util.*;

class SkipListNode {
    SkipListNode left, right, up, down;
    int value;
    public SkipListNode(int value) {
        this.value = value;
    }
}
class Skiplist {

    private List<SkipListNode> senital = new ArrayList<SkipListNode>();
    private Random random = new Random();
    private static final double DEFAULT_PROB = 0.5;

    public Skiplist() {
        senital.add(new SkipListNode(Integer.MIN_VALUE));
    }

    public boolean search(int target) {
        SkipListNode smallerOrEqual = getSmallerOrEqual(target);
        boolean found = smallerOrEqual.value == target;
        //System.out.println("Searching "+ target +" Found: "+found+"=============================================");
        //print();
        return found;
    }

    private SkipListNode getSmallerOrEqual(int target) {
        SkipListNode current = senital.get(senital.size() - 1);
        while(current != null) {
            if(current.right == null || current.right.value > target) {
                if(current.down == null) break;
                else current = current.down;
            }
            else current = current.right;
        }
        return current;
    }

    public void add(int num) {
        SkipListNode toInsert = new SkipListNode(num);
        SkipListNode prev = getSmallerOrEqual(num);
        append(prev, toInsert);
        populateLevelUp(toInsert);
        //System.out.println("Adding "+num+" =============================================");
        //print();
    }

    private void populateLevelUp(SkipListNode toInsert) {
        SkipListNode prev = toInsert.left;
        SkipListNode current = toInsert;
        while(coinFlip()) {
            while(prev.left != null && prev.up == null) {
                prev = prev.left;
            }
            if(prev.up == null) {
                SkipListNode newSenital = new SkipListNode(Integer.MIN_VALUE);
                prev.up = newSenital;
                newSenital.down = prev;
                senital.add(newSenital);
            }
            prev = prev.up;
            SkipListNode newCurrent = new SkipListNode(toInsert.value);
            current.up = newCurrent;
            newCurrent.down = current;
            current = newCurrent;
            prev.right = current;
            current.left = prev;
        }
    }

    private boolean coinFlip() {
        return random.nextDouble() < DEFAULT_PROB;
    }

    private void append(SkipListNode prev, SkipListNode toInsert) {
        SkipListNode next = prev.right;
        prev.right = toInsert;
        toInsert.left = prev;
        if(next != null) {
            toInsert.right = next;
            next.left = toInsert;
        }
    }

    public boolean erase(int num) {
        SkipListNode toRemove = getSmallerOrEqual(num);
        if(toRemove.value != num) return false;

        SkipListNode current = toRemove;
        while(current != null) {
            SkipListNode left = current.left;
            SkipListNode right = current.right;
            left.right = right;
            if(right != null) {
                right.left = left;
            }
            current = current.up;
        }
        //System.out.println("Erasing "+num+"=============================================");
        //print();
        return true;
    }

    public void print() {
        for(int i= 0; i < senital.size(); i++) {
            SkipListNode node = senital.get(i);
            while(node != null) {
                System.out.print(node.value + "->");
                node = node.right;
            }
            System.out.println();
        }
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */
