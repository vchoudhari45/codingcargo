package com.vc.hard;

class KthSmallestInstruction {
    public String kthSmallestPath(int[] destination, int k) {
        int rowTarget = destination[0];
        int colTarget = destination[1];

        int[][] matrix = new int[rowTarget + 1][colTarget + 1];
        for(int row = rowTarget; row >= 0; row--) {
            for(int col = colTarget; col >= 0; col--) {
                if(row == rowTarget && col == colTarget) {
                    matrix[row][col] = 1;
                }
                else if(row == rowTarget) {
                    matrix[row][col] = matrix[row][col + 1];
                }
                else if(col == colTarget) {
                    matrix[row][col] = matrix[row + 1][col];
                }
                else {
                    matrix[row][col] = matrix[row + 1][col] + matrix[row][col + 1];
                }
            }
        }

        return helper(matrix, 0, 0, k);
    }

    private String helper(int[][] matrix, int row, int col, int k) {
        if(row + 1 == matrix.length && col + 1 == matrix[0].length) {
            return "";
        }
        else if(row + 1 == matrix.length) {
            StringBuilder sb = new StringBuilder();
            while(++col < matrix[0].length) sb.append("H");
            return sb.toString();
        }
        else if(col + 1 == matrix[0].length) {
            StringBuilder sb = new StringBuilder();
            while(++row < matrix.length) sb.append("V");
            return sb.toString();
        }
        else {
            if(matrix[row][col + 1] >= k) {
                return "H" + helper(matrix, row, col + 1, k);
            }
            else {
                return "V" + helper(matrix, row + 1, col, k - matrix[row][col + 1]);
            }
        }
    }
}
