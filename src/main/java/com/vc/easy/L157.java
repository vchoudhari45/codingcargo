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
        char tmpBuf[] = new char[4];
        int index = 0;
        int charRead = 0;
        int tmpIndex = 0;
        while(index < n) {
            if(charRead == tmpIndex) {
                tmpIndex = 0;
                charRead = read4(tmpBuf);
                if(charRead == 0) break;
            }
            buf[index++] = tmpBuf[tmpIndex++];
        }
        return index;
    }
}