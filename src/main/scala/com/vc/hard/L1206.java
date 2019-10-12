package com.vc.hard;

import java.util.*;

class Node {
    Node left, right, up, down;
    int value;
    public Node(int value) {
        this.value = value;
    }
}
class Skiplist {

    private List<Node> senital = new ArrayList<Node>();
    private Random random = new Random();
    private static final double DEFAULT_PROB = 0.5;

    public Skiplist() {
        senital.add(new Node(Integer.MIN_VALUE));
    }

    public boolean search(int target) {
        Node smallerOrEqual = getSmallerOrEqual(target);
        boolean found = smallerOrEqual.value == target;
        //System.out.println("Searching "+ target +" Found: "+found+"=============================================");
        //print();
        return found;
    }

    private Node getSmallerOrEqual(int target) {
        Node current = senital.get(senital.size() - 1);
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
        Node toInsert = new Node(num);
        Node prev = getSmallerOrEqual(num);
        append(prev, toInsert);
        populateLevelUp(toInsert);
        //System.out.println("Adding "+num+" =============================================");
        //print();
    }

    private void populateLevelUp(Node toInsert) {
        Node prev = toInsert.left;
        Node current = toInsert;
        while(coinFlip()) {
            while(prev.left != null && prev.up == null) {
                prev = prev.left;
            }
            if(prev.up == null) {
                Node newSenital = new Node(Integer.MIN_VALUE);
                prev.up = newSenital;
                newSenital.down = prev;
                senital.add(newSenital);
            }
            prev = prev.up;
            Node newCurrent = new Node(toInsert.value);
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

    private void append(Node prev, Node toInsert) {
        Node next = prev.right;
        prev.right = toInsert;
        toInsert.left = prev;
        if(next != null) {
            toInsert.right = next;
            next.left = toInsert;
        }
    }

    public boolean erase(int num) {
        Node toRemove = getSmallerOrEqual(num);
        if(toRemove.value != num) return false;

        Node current = toRemove;
        while(current != null) {
            Node left = current.left;
            Node right = current.right;
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
            Node node = senital.get(i);
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
