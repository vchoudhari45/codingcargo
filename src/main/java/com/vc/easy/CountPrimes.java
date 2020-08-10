package com.vc.easy;

/*****
 *  Problem No: 204
 *  Category: Data Structures And Algorithms
 *  Tags: Math, Amazon, Microsoft, Leetcode, Easy
 *  Title: Count Primes
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Count the number of prime numbers less than a non-negative number, n. It is an easy problem that uses Math to solve the problem.
 *  Description: Count the number of prime numbers less than a non-negative number, n.
 *  Input: 10
 *  Output: 4 (There are 4 prime numbers less than 10, they are 2, 3, 5, 7)
 *  Similar Question: Ugly Number, Ugly Number II, Perfect Squares
 *****/

class CountPrimes {
    /**
     * Algorithm:
     * Base condition 0 & 1 are not prime numbers.
     * A prime number is a natural number greater than 1 that is not a product of two smaller natural numbers. A natural number greater than 1 that is not prime is called a composite number
     **/
    public int countPrimes(int n) {
        if(n == 0 || n == 1) return 0;
        boolean[] notPrime = new boolean[n];

        notPrime[0] = true;
        notPrime[1] = true;

        int sqrt = (int)Math.sqrt(n);
        int current = 2;
        while(current <= sqrt) {
            int j = 2;
            if(!notPrime[current]) {
                while(current * j < n) {
                    notPrime[current * j] = true;
                    j++;
                }
            }
            current++;
        }
        int count = 0;
        for(int i = 0; i < n; i++) if(!notPrime[i]) count++;
        return count;
    }
}
