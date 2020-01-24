package com.vc.medium;

class L779 {
    public int kthGrammar(int N, int K) {
        /**
             row 1: 0
             row 2: 01
             row 3: 0110
             row 4: 01101001

             -We see that, for any level N, the first half of the string is the same as the string in N-1,
             -the next half is just complement of it.

             -The total number of items in level N is 2^N.
             -The half mark of the string is marked by [2^(N-1)]-th item.

             So, for any level N:
             -if K is in the first half, it is same as the Kth element in level N-1
             -if K is in the second half,
             it is the complement of the number in [K-2^(N-1)]-th position in level N-1
        */
        int res = 0;
        while(K > 1) {
            K = K % 2 == 1 ? K + 1 : K / 2;
            res ^= 1;
        }
        return res;
    }
}
