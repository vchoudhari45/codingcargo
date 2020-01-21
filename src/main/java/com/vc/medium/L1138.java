package com.vc.medium;

class L1138 {
    public String alphabetBoardPath(String target) {
        int r = 0;
        int c = 0;
        char old = 'a';
        StringBuilder str = new StringBuilder();
        for(char ch: target.toCharArray()) {
            int[] newPos = charToPos(ch);
            if(ch == 'z') newPos[0]--;
            addPath(r, c, newPos[0], newPos[1], old, ch, str);
            r = newPos[0];
            c = newPos[1];
            old = ch;
        }
        return str.toString();
    }

    private void addPath(int rOld, int cOld, int rNew, int cNew, char old, char ch, StringBuilder path) {
        //System.out.println("Going from ("+rOld+", "+cOld+") to ("+rNew+", "+cNew+")");

        String vertical = "D";
        if(rOld > rNew) {
            vertical = "U";
        }
        String horizontal = "R";
        if(cOld > cNew) {
            horizontal = "L";
        }

        if(old == 'z' && ch != 'z') path.append('U');

        for(int i = Math.min(rOld, rNew); i < Math.max(rOld, rNew); i++) path.append(vertical);
        for(int i = Math.min(cOld, cNew); i < Math.max(cOld, cNew); i++) path.append(horizontal);

        if(ch == 'z' && old != 'z') path.append('D');

        path.append("!");
    }

    private int[] charToPos(char ch) {
        int index = ch - 'a';
        int row = index / 5;
        int col = index % 5;
        return new int[]{row, col};
    }
}
