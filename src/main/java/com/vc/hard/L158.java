package com.vc.hard;

class Reader4 {
    public int read4(char[] buf) {
        //dummy implementation for compilation, not required when using below solution in leetcode
        return 4;
    }
}
public class L158 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private char[] tempBuf = new char[4];
    private int index = 0, tempIndex = 0, charRead = 0;
    public int read(char[] buf, int n) {
        index = 0;
        while(index < n) {
            if(charRead == tempIndex) {
                tempIndex = 0;
                charRead = read4(tempBuf);
                if(charRead == 0) break;
            }
            buf[index++] = tempBuf[tempIndex++];
        }
        return index;
    }
}
