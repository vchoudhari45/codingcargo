package com.vc.hard;

class StudentAttendanceRecordIi {
    public int checkRecord(int n) {
        int MOD = (int)(1e9 + 7);

        if(n == 1) return 3;
        else if(n == 2) return 8;

        /**
             P = Number of sequences ending in 'P'
             A = Number of sequences ending in 'A'
             L = Number of sequences ending in 'L'

             P_NO_A = Number of sequences ending in 'P' and doesn't have 'A'
             L_NO_A = Number of sequences ending in 'L' and doesn't have 'A'
        */
        long[] P = new long[n + 1];
        long[] A = new long[n + 1];
        long[] L = new long[n + 1];
        long[] P_NO_A = new long[n + 1];
        long[] L_NO_A = new long[n + 1];

        /**
             When i = 1

             Number of sequences ending in 'P'
             P

             Number of sequences ending in 'A'
             A

             Number of sequences ending in 'L'
             L

             Number of sequences ending in 'P' and doesn't have 'A'
             P

             Number of sequences ending in 'L' and doesn't have 'A'
             L
        */
        P[1] = 1;
        A[1] = 1;
        L[1] = 1;
        P_NO_A[1] = 1;
        L_NO_A[1] = 1;

        /**
             When i = 2

             Number of sequences ending in 'P'
             PP
             LP
             AP

             Number of sequences ending in 'A'
             PA
             LA
             Not AA because more than one 'A' is not regarded as rewardable

             Number of sequences ending in 'L'
             PL
             AL
             LL

             Number of sequences ending in 'P' and doesn't have 'A'
             PP
             LP

             Number of sequences ending in 'L' and doesn't have 'A'
             PL
             LL
        */
        P[2] = 3;
        A[2] = 2;
        L[2] = 3;
        P_NO_A[2] = 2;
        L_NO_A[2] = 2;

        /**
             When i = 3

             Number of sequences ending in 'P'
             PPP
             APP
             LPP
             PAP
             Not AAP because more than one 'A' is not regarded as rewardable
             LAP
             PLP
             ALP
             LLP

             Number of sequences ending in 'A'
             PPA
             Not APA because more than one 'A' is not regarded as rewardable
             LPA
             Not PAA because more than one 'A' is not regarded as rewardable
             Not AAA because more than one 'A' is not regarded as rewardable
             Not LAA because more than one 'A' is not regarded as rewardable
             PLA
             Not ALA because more than one 'A' is not regarded as rewardable
             LLA

             Number of sequences ending in 'L'
             PPL
             APL
             LPL
             PAL
             Not AAL because more than one 'A' is not regarded as rewardable
             LAL
             PLL
             ALL
             Not LLL because more than two continuous 'L' is not regarded as rewardable

             Number of sequences ending in 'P' and doesn't have 'A'
             PPP
             Not APP because it has A
             LPP
             Not PAP because it has A
             Not AAP because it has A
             Not LAP because it has A
             PLP
             Not ALP because it has A
             LLP

             Number of sequences ending in 'L' and doesn't have 'A'
             PPL
             Not APL because it has A
             LPL
             Not PAL because it has A
             Not AAL because it has A
             Not LAL because it has A
             PLL
             Not ALL because it has A
             Not LLL because it has more than two continuous 'L'
        */
        P[3] = 8;
        A[3] = 4;
        L[3] = 7;
        P_NO_A[3] = 4;
        L_NO_A[3] = 3;

        /**
             Rule for P:                                                               You can append P to any Seq
             P(n) = P(n - 1) + L(n - 1) + A(n - 1)

             Rule for L: There can't be more than two continuous L
             L(n) =  P(n - 1)                                                          You can append L to Sequences ending in P
                   + A(n - 1)                                                          You can append L to Sequences ending in A
                   + if(n - 2 == 'A' || n - 2 == 'P') P(n - 2) + A(n - 2)              You can append L to Sequence, if Prev To Prev Character is NOT L

             Rule for A: There can't be more than one A
             A(n) =   P_NO_A(n - 1)                                                    You can append A to Sequences ending in P and has no 'A'
                    + L_NO_A(n - 1)                                                    You can append A to Sequences ending in L and has no 'A'


             P_NO_A(n) = A(n)                                                          You can append P to any Seq
             L_NO_A(n) = A(n - 1) + A(n - 2)
        */
        for(int i = 4; i <= n; i++) {
            P[i] = (P[i - 1] + L[i - 1] + A[i - 1]) % MOD;
            L[i] = (P[i - 1] + A[i - 1] + P[i - 2] + A[i - 2]) % MOD;
            A[i] = (P_NO_A[i - 1] + L_NO_A[i - 1]) % MOD;

            P_NO_A[i] = A[i];
            L_NO_A[i] = (A[i - 1] + A[i - 2]) % MOD;
        }

        return (int)((P[n] + L[n] + A[n]) % MOD);
    }
}