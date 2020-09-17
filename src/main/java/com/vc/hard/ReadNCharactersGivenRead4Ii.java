package com.vc.hard;

import java.util.Random;

class Reader4 {
    private Random random = new Random();
    public int read4(char[] buf) {
        int count = random.nextInt(5);
        for(int i = 0; i < count; i++) {
            buf[i] = (char) random.nextInt();
        }
        return count;
    }
}
public class ReadNCharactersGivenRead4Ii extends Reader4 {
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
