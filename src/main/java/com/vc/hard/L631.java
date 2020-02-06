package com.vc.hard;

import java.util.*;

class Excel {

    Cell[][] excel;

    class Cell {
        int val = 0;
        HashMap<Cell, Integer> formulaMap = new HashMap<>();

        Cell(int val) {
            setValue(val);
        }

        Cell(String[] formulas) {
            setFormula(formulas);
        }

        public void setValue(int val) {
            formulaMap.clear();
            this.val = val;
        }

        public int getValue() {
            if(formulaMap.isEmpty()) return val;
            int sum = 0;
            for(Cell cell: formulaMap.keySet()) {
                sum += cell.getValue() * formulaMap.get(cell);
            }
            return sum;
        }

        public void setFormula(String[] formulas) {
            formulaMap.clear();
            for(String formula: formulas) {
                if(formula.indexOf(":") < 0) {
                    int[] pos = getPos(formula);
                    addCellToFormula(pos[0], pos[1]);
                }
                else {
                    String[] range = formula.split(":");
                    int[] from = getPos(range[0]);
                    int[] to = getPos(range[1]);
                    for(int i = from[0]; i <= to[0]; i++) {
                        for(int j = from[1]; j <= to[1]; j++) {
                            addCellToFormula(i, j);
                        }
                    }
                }
            }
        }

        private void addCellToFormula(int row, int col) {
            if(excel[row][col] == null) excel[row][col] = new Cell(0);
            formulaMap.put(excel[row][col], formulaMap.getOrDefault(excel[row][col], 0) + 1);
        }


        private int[] getPos(String formula) {
            int col = formula.charAt(0) - 'A';
            int row = Integer.parseInt(formula.substring(1));
            return new int[]{row, col};
        }


    }

    public Excel(int H, char W) {
        excel = new Cell[H + 1][W - 'A' + 1];
    }

    public void set(int r, char c, int v) {
        if(excel[r][c - 'A'] == null) excel[r][c - 'A'] = new Cell(v);
        else excel[r][c - 'A'].setValue(v);
    }

    public int get(int r, char c) {
        if(excel[r][c - 'A'] == null) return 0;
        //System.out.println(excel[r][c - 'A'].formulaMap);
        return excel[r][c - 'A'].getValue();
    }

    public int sum(int r, char c, String[] strs) {
        if(excel[r][c - 'A'] == null) excel[r][c - 'A'] = new Cell(strs);
        else excel[r][c - 'A'].setFormula(strs);
        return excel[r][c - 'A'].getValue();
    }
}

/**
 * Your Excel object will be instantiated and called as such:
 * Excel obj = new Excel(H, W);
 * obj.set(r,c,v);
 * int param_2 = obj.get(r,c);
 * int param_3 = obj.sum(r,c,strs);
 */
