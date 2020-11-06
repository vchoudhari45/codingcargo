package com.vc.hard;

import java.util.*;

class DesignExcelSumFormula {

    private Cell[][] excel;

    class Cell {
        //A Cell can have a value
        int val = 0;

        //Or Cell can have formula
        //key  : Cell Reference
        //value: How many times Cell Reference has occurred in formula
        HashMap<Cell, Integer> sumFormulaMap = new HashMap<>();

        //Assigns
        Cell(int val) {
            setValue(val);
        }

        //Converts String Formula to Cell Reference
        Cell(String[] formula) {
            setFormula(formula);
        }


        public void setValue(int val) {
            sumFormulaMap.clear();
            this.val = val;
        }

        //Converts String Formula to Cell Reference
        public void setFormula(String[] formulas) {
            sumFormulaMap.clear();
            for(String formula: formulas) {
                int index = formula.indexOf(":");
                if(index < 0) {
                    int[] pos = getPos(formula);
                    int row = pos[0];
                    int col = pos[1];
                    if(excel[row][col] == null) {
                        excel[row][col] = new Cell(0);
                    }
                    sumFormulaMap.put(excel[row][col], sumFormulaMap.getOrDefault(excel[row][col], 0) + 1);
                }
                else {
                    String[] range = formula.split(":");
                    int[] from = getPos(range[0]);
                    int[] to = getPos(range[1]);
                    for(int row = from[0]; row <= to[0]; row++) {
                        for(int col = from[1]; col <= to[1]; col++) {
                            if(excel[row][col] == null) {
                                excel[row][col] = new Cell(0);
                            }
                            sumFormulaMap.put(excel[row][col],
                                    sumFormulaMap.getOrDefault(excel[row][col], 0) + 1);
                        }
                    }
                }
            }
        }

        public int getValue() {
            if(sumFormulaMap.size() == 0) return val;
            else {
                int sum = 0;
                for(Map.Entry<Cell, Integer> entry: sumFormulaMap.entrySet()) {
                    int cellValue = entry.getKey().getValue();
                    int ocurrance = entry.getValue();
                    sum += cellValue * ocurrance;
                }
                return sum;
            }
        }

        private int[] getPos(String formula) {
            int col = formula.charAt(0) - 'A';
            int row = Integer.parseInt(formula.substring(1));
            return new int[]{row, col};
        }
    }


    public DesignExcelSumFormula(int H, char W) {
        this.excel = new Cell[H + 1][W - 'A' + 1];
    }

    public void set(int r, char c, int v) {
        if(excel[r][c - 'A'] == null) excel[r][c - 'A'] = new Cell(v);
        else excel[r][c - 'A'].setValue(v);
    }

    public int get(int r, char c) {
        if(excel[r][c - 'A'] == null) return 0;
        else return excel[r][c - 'A'].getValue();
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