package com.vc.hard;

class L552 {
    public int checkRecord(int n){
        int MOD = (int) (1e9 + 7);
        /**
             P[i] = Number of Sequences ending in 'P'
             L[i] = Number of Sequences ending in 'L'
             A[i] = Number of Sequences ending in 'A'

             n       P         L           A       P_CONTAINS_NO_A     L_CONTAINS_NO_A
             1       1         1           1              1                   1             When length is 1
                    (P)       (L)          (A)           (P)                 (L)

             2       3         3           2             2                   2              When length is 2
                   (         (            (            (                  (
                     PP,       PL,          PA,          PP,                 PL,
                     LP,       AL,          LA           LP                  LL
                     AP        LL         )            )                   )
                   )         )

             3      8         7             4           4                   3               When length is 3
                  (         (            (           (                   (
                     PPP,      PPL,         PPA,        PPP,                  PPL,
                     LPP,      LPL,         LPA,        LPP,                  LPL,
                     APP,      APL,         PLA,        PLP                   PLL
                     PLP,      PLL,         LLA         LLP                )
                     ALP,      ALL        )            )
                     LLP,      PAL,
                     PAP,      LAL
                     LAP     )
                   )

             Rule for P: You can append P to any Seq
             P(n) = P(n - 1) + L(n - 1) + A(n - 1)

             Rule for L: There can't be more than two continuous L
             L(n) =  P(n - 1)                                                               You can append L to Sequences ending in P
                   + A(n - 1)                                                               You can append L to Sequences ending in A
                   + if(n - 2 == 'A' || n - 2 == 'P') L(n - 1)  i.e. P(n - 2) + A(n - 2)    You can append L to Sequence ending in L only if PrevToPrev Character is not L, i.e. PrevtoPrev Character is either A OR P

             L(n) = P(n - 1) + A(n - 1) + P(n - 2) + A(n - 2)


             Rule for A: There can't be more than one A
             A(n) =   P_CONTAINS_NO_A(n - 1)              You can append A to Sequences ending in P and has no 'A'
                    + L_CONTAINS_NO_A(n - 1)             You can append A to Sequences ending in L and has no 'A'

             P_CONTAINS_NO_A(n) = P_CONTAINS_NO_A(n - 1) + L_CONTAINS_NO_A(n - 1)
             L_CONTAINS_NO_A(n) = P_CONTAINS_NO_A(n - 1) + P_CONTAINS_NO_A(n - 2)
         */
        if(n == 1) return 3;
        else if(n == 2) return 8;

        long[] p = new long[n];
        long[] l = new long[n];
        long[] a = new long[n];
        long[] p_no_a = new long[n];
        long[] l_no_a = new long[n];

        //All the recurrence relations hold after n >= 3
        p[0] = 1;
        l[0] = 1;
        a[0] = 1;

        p[1] = 3;
        l[1] = 2;
        a[1] = 2;

        p[2] = 8;
        l[2] = 7;
        a[2] = 4;

        p_no_a[0] = 1;
        l_no_a[0] = 1;

        p_no_a[1] = 2;
        l_no_a[1] = 2;

        p_no_a[2] = 4;
        l_no_a[2] = 3;


        for(int i = 3; i < n; i++) {
            p[i] = (p[i - 1] + l[i - 1] + a[i - 1]) % MOD;
            l[i] = (p[i - 1] + a[i - 1]) % MOD + (p[i - 2] + a[i - 2]) % MOD;
            a[i] = (p_no_a[i - 1] + l_no_a[i - 1]) % MOD;

            p_no_a[i] = (p_no_a[i - 1] + l_no_a[i - 1]) % MOD ;
            l_no_a[i] = (p_no_a[i - 1] + p_no_a[i - 2]) % MOD;
        }

        return (int) ((p[n - 1] + l[n - 1] + a[n - 1]) % MOD);
    }
}