package com.vc.easy;

/*****
 *  Problem No: 28
 *  Category: Data Structures And Algorithms
 *  Tags: KMP(Knuth Morris Pratt algorithm), String, Amazon, Facebook, Microsoft, Leetcode, Easy
 *  Title: Implement strStr
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Return the index of the first occurrence of needle in a haystack, or -1 if a needle is not part of haystack. It is an easy problem that uses KMP(Knuth Morris Pratt String Searching algorithm) to solve the problem.
 *  Description: Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *  Input: haystack = "hello", needle = "ll"
 *  Output: 2
 *  Input: haystack = "aaaaa", needle = "bba"
 *  Output: -1
 *  Similar Question: Shortest Palindrome, Repeated Substring Pattern
 *****/

class ImplementStrStr {
    /**
     *  We use KMP (Knuth Morris Pratt algorithm) search algorithm
     *
     *  Algorithm:
     *  Consider
     *  needle  : aabaaab       Pattern to Search
     *  haystack: aaabaaab      String to Search Pattern in
     *
     *  Initially matchedPrefixLength = 0 and we start to process the Pattern(needle in our case) from i = 1
     *
     *  1. We pre-process the pattern(needle in this case) to generate lps(Longest prefix which is also a suffix) array as below
     *     1.1. If needle.charAt(matchedPrefixLength) == needle.charAt(i) then we found a suffix which matches prefix, we record suffix length which matches prefix in lps Array
     *          For e.g. needle.charAt(index = 0) == needle.charAt(i = 1), it means suffix a with length 1 matches prefix with length 1
     *                   Then Record suffix length = 1 into lps Array lps[i] = ++index
     *
     *     1.2. Else Two Scenarios
     *          1.2.1. matchesPrefixLength != 0, then we see if current suffix - current character matches any prefix
     *          1.2.2. We skip current character and start matching from beginning
     *
     *  2. We match pattern(needle in our case) with haystack(String to search pattern in) in a similar way as we pre-processed our pattern.
     **/
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return 0;
        if(haystack == null || haystack.length() == 0 || haystack.length() < needle.length()) return -1;

        int n = haystack.length();
        int m = needle.length();
        int[] lps = new int[m];
        int matchedPrefixLength = 0;
        for(int i = 1; i < m;) {
            //If needle.charAt(matchedPrefixLength) == needle.charAt(i) then we found a suffix which matches prefix, We record suffix length which matches prefix in lps Array
            if(needle.charAt(i) == needle.charAt(matchedPrefixLength)) {
                lps[i] = ++matchedPrefixLength;
                i++;
            }
            //Else Two Scenarios
            else {
                // matchesPrefixLength != 0, then we see if current suffix - current character matches any prefix
                if(matchedPrefixLength != 0) matchedPrefixLength = lps[matchedPrefixLength - 1];

                //We skip current character and start matching from beginning
                else i++;
            }
        }

        //Process Haystack with same algorithm as above
        matchedPrefixLength = 0;
        for(int i = 0; i < n;) {
            if(matchedPrefixLength == m) return i - matchedPrefixLength;
            if(haystack.charAt(i) == needle.charAt(matchedPrefixLength)) {
                i++;
                matchedPrefixLength++;
            }
            else {
                if(matchedPrefixLength != 0) matchedPrefixLength = lps[matchedPrefixLength - 1];
                else i++;
            }
        }
        return matchedPrefixLength == needle.length() ? haystack.length() - matchedPrefixLength : -1;
    }
}