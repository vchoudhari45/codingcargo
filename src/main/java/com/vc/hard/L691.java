package com.vc.hard;

class L691 {
    public int minStickers(String[] stickers, String target) {
        /**
             target: hat
             stickers: haha
             tata

             possible states dp[1 << hat.length()]
             hat -> final state 111 and 000 as initial state

             iteration 1:
             000 -> apply first sticker 110, apply second sticker 011
             001 -> -1
             010 -> -1
             011 -> one sticker of tata
             100 -> -1
             101 -> -1
             110 -> one sticker haha
             111 -> -1

             iteration 2: find next non "-1" state which is 011 and apply stickers
             000 -> apply first sticker 110, apply second sticker 011
             001 -> -1
             010 -> -1
             011 ->  1(tata) applying haha
             100 -> -1
             101 -> -1
             110 ->  1(haha)
             111 ->  2(haha + tata)

             And so on ...
         */
        int n = target.length();
        int[] dp = new int[1 << n];
        for(int i = 1; i < (1 << n); i++) dp[i] = -1;

        for(int state = 0; state < (1 << n); state++) {
            if(dp[state] == -1) continue;
            for(String sticker: stickers) {
                int initialState = state;
                // System.out.format("%"+n+"s",Integer.toBinaryString(initialState));
                // System.out.println();
                for(char ch: sticker.toCharArray()) {
                    for(int i = 0; i < n; i++) {
                        // We can't use current sticker's character as we already have that character set in target
                        if (((initialState >> i) & 1) == 1) continue;
                        if(target.charAt(i) == ch) {
                            initialState |= (1 << i);
                            break; // Cause we want to start with next character in the sticker
                        }
                    }
                }
                // System.out.format("%"+n+"s",Integer.toBinaryString(initialState));
                // System.out.println();
                if(dp[initialState] == -1 || dp[initialState] > dp[state] + 1) {
                    dp[initialState] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}