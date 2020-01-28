package com.vc.easy;

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

class Reader4 {
    public int read4(char[] buf) {
        //dummy implementation for compilation, not required when using below solution in leetcode
        return 4;
    }
}
class L157 extends Reader4 {
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
}