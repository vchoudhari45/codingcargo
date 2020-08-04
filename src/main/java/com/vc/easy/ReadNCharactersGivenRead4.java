package com.vc.easy;

import java.util.Random;

/*****
 *  Problem No: 157
 *  Category: Data Structures And Algorithms
 *  Tags: String, Facebook, Google, Leetcode, Easy
 *  Title: Read N Characters Given Read4
 *  MetaDescription: Java Solution to Data Structures And Algorithms problem, Given method read4, implement a method to read n characters. It is an easy problem that uses Array Data Structure to solve the problem.
 *  Description: Given a method read4, implement a method read n characters. The method read4 generates characters randomly and writes them into the buffer array buf. The return value is the number of actual characters written to buffer, which can be anything between 0 and 5.
 *  Input: randomlyGeneratedCharacters by read4 = "abc", n = 4
 *  Output: 3
 *  Similar Question: Read N Characters Given Read4 II - Call multiple times
 *****/

class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] tempBuf = new char[4];
        int index = 0, charIndex = 0, tempIndex = 0;
        while(index < n) {
            if(charIndex == tempIndex) {
                tempIndex = 0;
                charIndex = read4(tempBuf);
                if(charIndex == 0) break;
            }
            buf[index++] = tempBuf[tempIndex++];
        }
        return index;
    }

    /**
     * This method is provided
     **/
    private int read4(char[] buf) {
        Random random = new Random();
        int count = random.nextInt(5);
        for(int i = 0; i < count; i++) {
            buf[i] = 'A';
        }
        return count;
    }
}