package com.vc.medium;

import java.util.*;

class L313 {
    static class Prime {
        int next;
        int index;
        int prime;

        Prime(int next, int index, int prime) {
            this.next = next;
            this.index = index;
            this.prime = prime;
        }
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Prime> pq = new PriorityQueue<>(new Comparator<Prime>(){
            public int compare(Prime p1, Prime p2) {
                return Integer.compare(p1.next, p2.next);
            }
        });

        for(int i = 0; i < primes.length; i++) {
            pq.offer(new Prime(primes[i], 1, primes[i]));
        }

        int[] arr = new int[n];
        arr[0] = 1;
        for(int i = 1; i < n; i++) {
            arr[i] = pq.peek().next;
            while(arr[i] == pq.peek().next) {
                Prime nextPrime = pq.poll();
                pq.add(new Prime(nextPrime.prime * arr[nextPrime.index],
                        nextPrime.index + 1, nextPrime.prime));
            }
        }
        return arr[n - 1];
    }
}
