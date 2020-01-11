package com.vc.medium;

import java.util.concurrent.*;

class BoundedBlockingQueue {

    int[] queue;
    int addIndex = 0;
    int removeIndex = 0;
    int capacity = 0;
    int size = 0;
    Semaphore enq;
    Semaphore deq;

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        enq = new Semaphore(capacity);
        deq = new Semaphore(0);
    }

    public void enqueue(int element) throws InterruptedException {
        //System.out.println("Adding element: "+element+" at index: "+addIndex);
        enq.acquire();
        queue[addIndex++] = element;
        if(addIndex == capacity) addIndex = 0;
        size++;
        deq.release();
        //System.out.println("--Added element: "+element+" at index: "+addIndex);
    }

    public int dequeue() throws InterruptedException {
        //System.out.println("Removing element from index: "+removeIndex);
        deq.acquire();
        int e = queue[removeIndex++];
        if(removeIndex == capacity) removeIndex = 0;
        enq.release();
        size--;
        //System.out.println("--Removed element from index: "+removeIndex);
        return e;
    }

    public int size() {
        return size;
    }
}
