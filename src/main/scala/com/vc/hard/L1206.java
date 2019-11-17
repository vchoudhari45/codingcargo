package com.vc.hard;

import java.util.*;

class Node1206 {
    Node1206 left, right, up, down;
    int value;
    public Node1206(int value) {
        this.value = value;
    }
}
class Skiplist {

    private List<Node1206> senital = new ArrayList<Node1206>();
    private Random random = new Random();
    private static final double DEFAULT_PROB = 0.5;

    public Skiplist() {
        senital.add(new Node1206(Integer.MIN_VALUE));
    }

    public boolean search(int target) {
        Node1206 smallerOrEqual = getSmallerOrEqual(target);
        boolean found = smallerOrEqual.value == target;
        //System.out.println("Searching "+ target +" Found: "+found+"=============================================");
        //print();
        return found;
    }

    private Node1206 getSmallerOrEqual(int target) {
        Node1206 current = senital.get(senital.size() - 1);
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
        Node1206 toInsert = new Node1206(num);
        Node1206 prev = getSmallerOrEqual(num);
        append(prev, toInsert);
        populateLevelUp(toInsert);
        //System.out.println("Adding "+num+" =============================================");
        //print();
    }

    private void populateLevelUp(Node1206 toInsert) {
        Node1206 prev = toInsert.left;
        Node1206 current = toInsert;
        while(coinFlip()) {
            while(prev.left != null && prev.up == null) {
                prev = prev.left;
            }
            if(prev.up == null) {
                Node1206 newSenital = new Node1206(Integer.MIN_VALUE);
                prev.up = newSenital;
                newSenital.down = prev;
                senital.add(newSenital);
            }
            prev = prev.up;
            Node1206 newCurrent = new Node1206(toInsert.value);
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

    private void append(Node1206 prev, Node1206 toInsert) {
        Node1206 next = prev.right;
        prev.right = toInsert;
        toInsert.left = prev;
        if(next != null) {
            toInsert.right = next;
            next.left = toInsert;
        }
    }

    public boolean erase(int num) {
        Node1206 toRemove = getSmallerOrEqual(num);
        if(toRemove.value != num) return false;

        Node1206 current = toRemove;
        while(current != null) {
            Node1206 left = current.left;
            Node1206 right = current.right;
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
            Node1206 node = senital.get(i);
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
