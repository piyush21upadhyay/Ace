package com.ace.array.medium;

import java.util.HashSet;
import java.util.Set;

/*https://takeuforward.org/data-structure/set-matrix-zero/
Given a matrix if an element in the matrix is 0 then
you will have to set its entire column and row to 0 and then return the matrix.
Examples 1:
Input:
matrix=[[1,1,1],[1,0,1],[1,1,1]]

Output:
        [[1,0,1],[0,0,0],[1,0,1]]*/
public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] result = setMatrixZero(matrix);
        for (int[] row : result) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    /*
    Identify Rows and Columns to Zero: First, you need to identify which rows and columns should be set to zero. You can achieve this by iterating over the matrix and recording the indices of the rows and columns that contain zeroes.

Set Rows and Columns to Zero: Once you have the indices of the rows and columns, iterate through the matrix again and set the appropriate rows and columns to zero.
    /
     */
    private static int[][] setMatrixZero(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Sets to store the indices of rows and columns to be zeroed
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();

        // First pass: identify which rows and columns need to be zeroed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // Second pass: zero out the identified rows
        for (int row : zeroRows) {
            for (int j = 0; j < cols; j++) {
                matrix[row][j] = 0;
            }
        }

        // Third pass: zero out the identified columns
        for (int col : zeroCols) {
            for (int i = 0; i < rows; i++) {
                matrix[i][col] = 0;
            }
        }
        return matrix;

    }
}
